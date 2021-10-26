package com.github.jhamin0511.diffutil.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.dto.User
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "UserListAdapter"

class UserListAdapter(
    private val listener: UserListener
) : ListAdapter<User, RecyclerView.ViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class Holder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        private val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        private val name: TextView = view.findViewById(R.id.name)
        private val age: TextView = view.findViewById(R.id.age)
        private val date: TextView = view.findViewById(R.id.date)

        fun bind(value: User) {
            view.setOnClickListener {
                listener.onClickHolder(value, absoluteAdapterPosition)
            }
            view.setOnLongClickListener {
                listener.onLongClickHolder(value, absoluteAdapterPosition)
            }

            name.text = value.name
            age.text = value.age.toString()
            date.text = format.format(value.createdAt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Holder).bind(getItem(position))
    }

}
