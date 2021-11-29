package com.github.jhamin0511.diffutil.ui.list

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.dto.UserCreator
import com.github.jhamin0511.diffutil.data.dto.UserDto
import com.github.jhamin0511.diffutil.data.mapper.UserMapper
import com.github.jhamin0511.diffutil.ui.edit.EditActivity
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), UserListener {

    private val adapter = UserListAdapter(this)
    private val mapper = UserMapper()
    private val dataSource: MutableList<UserDto> = UserCreator.default().toMutableList()
    private val userEditResult = registerForActivityResult(StartActivityForResult()) {
        Log.i(TAG, "StartActivityForResult()")
        if (it.resultCode == Activity.RESULT_OK) {
            val userDto: UserDto = it.data!!.getParcelableExtra("USER")!!
            val item = dataSource.find { data -> data.id == userDto.id }
            val position = dataSource.indexOf(item)
            dataSource[position] = userDto
            submit()
        }
    }

    init {
        submit()
    }

    private fun submit() {
        val list = mapper.toList(dataSource.toList())
        adapter.submitList(list)
    }

    private fun submit(commitCallback: Runnable) {
        val list = mapper.toList(dataSource.toList())
        adapter.submitList(list, commitCallback)
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
//                    submit()
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
                dataSource.add(0, UserDto(value, value.toString(), value, Date()))
                submit{
                    list.smoothScrollToPosition(0)
                }
            }
            R.id.delete_all -> {
                dataSource.clear()
                submit()
            }
            R.id.refresh -> {
                dataSource.clear()
                dataSource.addAll(UserCreator.default())
                submit()
            }
            R.id.mix -> {
                dataSource.reverse()
                submit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickHolder(id: Int) {
        val item = dataSource.find { it.id == id }
        if (item != null) {
            val intent = EditActivity.start(this, item)
            userEditResult.launch(intent)
        }
    }

    override fun onLongClickHolder(id: Int): Boolean {
        AlertDialog.Builder(this)
            .setTitle("삭제")
            .setPositiveButton(android.R.string.ok) { _, _ ->
                val item = dataSource.find { it.id == id }
                if (item != null) {
                    dataSource.remove(item)
                    submit()
                }
            }.setNegativeButton(android.R.string.cancel) { _, _ ->

            }.show()

        return true
    }

}
