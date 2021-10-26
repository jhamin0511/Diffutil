package com.github.jhamin0511.diffutil.data.mapper

import com.github.jhamin0511.diffutil.data.dto.UserCreator
import com.github.jhamin0511.diffutil.data.vo.ListVo
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class UserMapperTest {

    @Test
    fun toList() {
        // Given
        val list = mutableListOf<ListVo>()
        val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
        val value = UserCreator.default()
        // When
        val sorted = value.sortedBy { it.createdAt }.reversed().also(::println)
        // Then
    }

}
