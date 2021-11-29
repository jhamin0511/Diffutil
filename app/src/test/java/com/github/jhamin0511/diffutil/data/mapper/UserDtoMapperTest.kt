package com.github.jhamin0511.diffutil.data.mapper

import com.github.jhamin0511.diffutil.data.dto.UserCreator
import org.junit.Test

class UserDtoMapperTest {

    private val mapper = UserMapper()

    @Test
    fun toList() {
        // Given
        val list = UserCreator.default()
        // When
        val voList = mapper.toList(list)
        // Then
        voList.forEach {
            println(it)
        }
    }

}
