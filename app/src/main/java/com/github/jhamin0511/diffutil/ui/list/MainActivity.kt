package com.github.jhamin0511.diffutil.ui.list

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.dto.User
import com.github.jhamin0511.diffutil.data.dto.UserCreator
import com.github.jhamin0511.diffutil.ui.edit.EditActivity
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), UserListener {

    private val adapter = UserListAdapter(this)
    private val dataSource: MutableList<User> = UserCreator.default().toMutableList()
    private val userEditResult = registerForActivityResult(StartActivityForResult()) {
        Log.i(TAG, "StartActivityForResult()")
        if (it.resultCode == Activity.RESULT_OK) {
            val user: User = it.data!!.getParcelableExtra("USER")!!
            val position = it.data!!.getIntExtra("position", -1)
            Log.i(TAG, "user position : ${position}")
            if (position != -1) {
                dataSource[position] = user
                adapter.submitList(dataSource.toList())
            }
        }
    }

    init {
        adapter.submitList(dataSource.toList())
    }

    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = findViewById(R.id.list)
        list.adapter = adapter

//        list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//
//                val lastVisibleItemPosition =
//                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
//                val itemTotalCount = recyclerView.adapter!!.itemCount - 1
//
//                // 스크롤이 끝에 도달했는지 확인
//                if (lastVisibleItemPosition == itemTotalCount) {
//                    val value = dataSource.size + 1
//                    val items = UserCreator.addMany(value)
//                    dataSource.addAll(items)
//                    adapter.submitList(dataSource.toList())
//                }
//            }
//        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onOptionsItemSelected : ${item.itemId}")
        when (item.itemId) {
            R.id.add -> {
                val value = dataSource.size + 1
                dataSource.add(0, User(value, value.toString(), value, Date()))
                adapter.submitList(dataSource.toList()) {
                    list.smoothScrollToPosition(0)
                }
            }
            R.id.delete_all -> {
                dataSource.clear()
                adapter.submitList(dataSource.toList())
            }
            R.id.refresh -> {
                dataSource.clear()
                dataSource.addAll(UserCreator.default())
                adapter.submitList(dataSource.toList())
            }
            R.id.mix -> {
                dataSource.reverse()
                adapter.submitList(dataSource.toList())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickHolder(value: User, position: Int) {
        val item = dataSource[position]
        val intent = EditActivity.start(this, position, item)
        userEditResult.launch(intent)
    }

    override fun onLongClickHolder(value: User, position: Int): Boolean {
        AlertDialog.Builder(this)
            .setTitle("삭제")
            .setPositiveButton(android.R.string.ok) { _, _ ->
                dataSource.remove(value)
                adapter.submitList(dataSource)
                adapter.notifyItemRemoved(position)
            }.setNegativeButton(android.R.string.cancel) { _, _ ->

            }.show()

        return true
    }

}
