package com.github.jhamin0511.diffutil.ui.edit

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.dto.User
import com.github.jhamin0511.diffutil.util.DateFormatUtil
import java.util.*

private const val TAG = "EditActivity"

class EditActivity : AppCompatActivity() {

    private val format = DateFormatUtil(DateFormatUtil.YYYY_MM_DD)

    companion object {
        fun start(context: Context, position: Int, value: User): Intent {
            return Intent(context, EditActivity::class.java).apply {
                putExtra("position", position)
                putExtra("USER", value)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val user: User = intent.getParcelableExtra("USER")!!
        val name: TextView = findViewById(R.id.name)
        val age: TextView = findViewById(R.id.age)
        val date: TextView = findViewById(R.id.date)
        val save: Button = findViewById(R.id.save)

        name.text = user.name
        age.text = user.age.toString()
        date.text = format.format(user.createdAt)

        date.setOnClickListener {
            val cal = GregorianCalendar()
            cal.time = user.createdAt

            DatePickerDialog(this, { view, year, month, dayOfMonth ->
                val dateSet = GregorianCalendar(year, month, dayOfMonth)
                user.createdAt = dateSet.time
                date.text = format.format(dateSet.time)
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
                .show()
        }
        save.setOnClickListener {
            user.name = name.text.toString()
            user.age = age.text.toString().toInt()

            intent.apply {
                putExtra("USER", user)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}
