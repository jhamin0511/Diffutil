package com.github.jhamin0511.diffutil.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.diffutil.R
import com.github.jhamin0511.diffutil.data.vo.UserDateVo
import com.github.jhamin0511.diffutil.data.vo.UserItem
import com.github.jhamin0511.diffutil.data.vo.UserListVo
import com.github.jhamin0511.diffutil.data.vo.UserViewType

private const val TAG = "UserListAdapter"

class UserListAdapter(
    private val listener: UserListener
) : ListAdapter<UserItem, RecyclerView.ViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<UserItem>() {
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return if (oldItem is UserListVo && newItem is UserListVo) {
                    oldItem.id == newItem.id
                } else if (oldItem is UserDateVo && newItem is UserDateVo) {
                    oldItem.date.contentEquals(newItem.date)
                } else {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return if (oldItem is UserListVo && newItem is UserListVo) {
                    oldItem == newItem
                } else if (oldItem is UserDateVo && newItem is UserDateVo) {
                    oldItem == newItem
                } else {
                    oldItem == newItem
                }
            }
        }
    }

    inner class DateHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        private val date: TextView = view.findViewById(R.id.date)

        fun bind(value: String) {
            date.text = value
        }
    }

    inner class ListHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.name)
        private val age: TextView = view.findViewById(R.id.age)

        fun bind(value: UserListVo) {
            view.setOnClickListener {
                listener.onClickHolder(value.id)
            }
            view.setOnLongClickListener {
                listener.onLongClickHolder(value.id)
            }

            name.text = value.name
            age.text = value.age.toString()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            UserViewType.DATE.ordinal -> {
                val view = inflater.inflate(R.layout.item_data, parent, false)
                DateHolder(view)
            }
            UserViewType.LIST.ordinal -> {
                val view = inflater.inflate(R.layout.item_user_list, parent, false)
                ListHolder(view)
            }
            else -> throw IllegalArgumentException("not create ViewHolder.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val value = getItem(position)

        if (holder is DateHolder) {
            holder.bind((value as UserDateVo).date)
        } else if(holder is ListHolder) {
            holder.bind((value as UserListVo))
        } else {
            throw IllegalArgumentException("not bind ViewHolder.")
        }
    }

}
