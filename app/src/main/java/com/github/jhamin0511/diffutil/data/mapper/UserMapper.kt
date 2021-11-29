package com.github.jhamin0511.diffutil.data.mapper

import com.github.jhamin0511.diffutil.data.dto.UserDto
import com.github.jhamin0511.diffutil.data.vo.UserDateVo
import com.github.jhamin0511.diffutil.data.vo.UserItem
import com.github.jhamin0511.diffutil.data.vo.UserListVo
import java.text.SimpleDateFormat
import java.util.*

class UserMapper {
    private val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())

    fun toList(value: List<UserDto>): List<UserItem> {
        val sorted = value.sortedByDescending { it.createdAt }
        val maps = sorted.map { UserListVo(it.id, it.name, it.age, format.format(it.createdAt)) }
        val group = maps.groupBy { it.date }

        val list = mutableListOf<UserItem>()

        group.forEach { (key, value) ->
            list.add(UserDateVo(key))
            list.addAll(value)
        }

        return list
    }

}
