package com.github.jhamin0511.diffutil.data.dto

import java.util.*

object UserCreator {

    fun default(): List<UserDto> {
        val list = mutableListOf<UserDto>()
        val calendar = GregorianCalendar.getInstance()

        list.add(UserDto(1, "일", 1, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(2, "이", 2, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(3, "삼", 3, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(4, "사", 4, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(5, "오", 5, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(6, "육", 6, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(7, "칠", 7, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(8, "팔", 8, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -6)
        list.add(UserDto(9, "구", 9, Date(calendar.timeInMillis)))

        calendar.add(Calendar.DAY_OF_MONTH, -10)
        list.add(UserDto(10, "십", 10, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(11, "십일", 11, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(12, "십이", 12, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(13, "십삼", 13, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(14, "십사", 14, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(15, "십오", 15, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(16, "십육", 16, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(17, "십칠", 17, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(18, "십팔", 18, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(19, "십구", 19, Date(calendar.timeInMillis)))

        calendar.add(Calendar.DAY_OF_MONTH, 5)
        list.add(UserDto(20, "이십", 20, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(21, "이십일", 21, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(22, "이십이", 22, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(23, "이십삼", 23, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(24, "이십사", 24, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(25, "이십오", 25, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(26, "이십육", 26, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(27, "이십칠", 27, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(28, "이십팔", 28, Date(calendar.timeInMillis)))
        calendar.add(Calendar.HOUR_OF_DAY, -10)
        list.add(UserDto(29, "이십구", 29, Date(calendar.timeInMillis)))

        calendar.add(Calendar.DAY_OF_MONTH, 3)
        list.add(UserDto(30, "삼십", 30, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(31, "삼십일", 31, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(32, "삼십이", 32, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(33, "삼십삼", 33, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(34, "삼십사", 34, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(35, "삼십오", 35, Date(calendar.timeInMillis)))

        calendar.add(Calendar.DAY_OF_MONTH, 3)
        list.add(UserDto(36, "삼십육", 36, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(37, "삼십칠", 37, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(38, "삼십팔", 38, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(39, "삼십구", 39, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(40, "사십", 40, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(41, "사십일", 41, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(42, "사십이", 42, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(43, "사십삼", 43, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(44, "사십사", 44, Date(calendar.timeInMillis)))
        calendar.add(Calendar.DAY_OF_MONTH, -6)
        list.add(UserDto(45, "사십오", 45, Date(calendar.timeInMillis)))

        return list.sortedBy { it.createdAt }.reversed()
    }

    fun addMany(currentSize: Int): MutableList<UserDto> {
        val list = mutableListOf<UserDto>()

        for (i in 1..100) {
            val index = currentSize + i
            list.add(UserDto(index, index.toString(), index, Date()))
        }

        return list
    }
}