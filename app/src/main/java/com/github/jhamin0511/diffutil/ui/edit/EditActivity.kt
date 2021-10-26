package com.github.jhamin0511.diffutil.ui.edit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.dto.User

private const val TAG = "EditActivity"

class EditActivity : AppCompatActivity() {

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
        val save: Button = findViewById(R.id.save)

        name.text = user.name
        age.text = user.age.toString()

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
