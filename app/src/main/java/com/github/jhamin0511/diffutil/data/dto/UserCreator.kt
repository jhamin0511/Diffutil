package com.github.jhamin0511.diffutil.data.dto

import java.util.*

object UserCreator {

    fun default(): List<User> {
        val list = mutableListOf<User>()
        val calendar = GregorianCalendar.getInstance()

        calendar.add(Calendar.DAY_OF_MONTH, -10)
        list.addAll(
            listOf(
                User(1, "일", 1, Date(calendar.timeInMillis)),
                User(2, "이", 2, Date(calendar.timeInMillis)),
                User(3, "삼", 3, Date(calendar.timeInMillis)),
                User(4, "사", 4, Date(calendar.timeInMillis)),
                User(5, "오", 5, Date(calendar.timeInMillis)),
                User(6, "육", 6, Date(calendar.timeInMillis)),
                User(7, "칠", 7, Date(calendar.timeInMillis)),
                User(8, "팔", 8, Date(calendar.timeInMillis)),
                User(9, "구", 9, Date(calendar.timeInMillis)),
            )
        )

        calendar.add(Calendar.DAY_OF_MONTH, -10)
        list.addAll(
            listOf(
                User(10, "십", 10, Date(calendar.timeInMillis)),
                User(11, "십일", 11, Date(calendar.timeInMillis)),
                User(12, "십이", 12, Date(calendar.timeInMillis)),
                User(13, "십삼", 13, Date(calendar.timeInMillis)),
                User(14, "십사", 14, Date(calendar.timeInMillis)),
                User(15, "십오", 15, Date(calendar.timeInMillis)),
                User(16, "십육", 16, Date(calendar.timeInMillis)),
                User(17, "십칠", 17, Date(calendar.timeInMillis)),
                User(18, "십팔", 18, Date(calendar.timeInMillis)),
                User(19, "십구", 19, Date(calendar.timeInMillis))
            )
        )

        calendar.add(Calendar.DAY_OF_MONTH, 5)
        list.addAll(
            listOf(
                User(20, "이십", 20, Date(calendar.timeInMillis)),
                User(21, "이십일", 21, Date(calendar.timeInMillis)),
                User(22, "이십이", 22, Date(calendar.timeInMillis)),
                User(23, "이십삼", 23, Date(calendar.timeInMillis)),
                User(24, "이십사", 24, Date(calendar.timeInMillis)),
                User(25, "이십오", 25, Date(calendar.timeInMillis)),
                User(26, "이십육", 26, Date(calendar.timeInMillis)),
                User(27, "이십칠", 27, Date(calendar.timeInMillis)),
                User(28, "이십팔", 28, Date(calendar.timeInMillis)),
                User(29, "이십구", 29, Date(calendar.timeInMillis)),
            )
        )

        calendar.add(Calendar.DAY_OF_MONTH, -10)
        list.addAll(
            listOf(
                User(30, "삼십", 30, Date(calendar.timeInMillis)),
                User(31, "삼십일", 31, Date(calendar.timeInMillis)),
                User(32, "삼십이", 32, Date(calendar.timeInMillis)),
            )
        )

        return list.sortedBy { it.createdAt }.reversed()
    }

    fun addMany(currentSize: Int): MutableList<User> {
        val list = mutableListOf<User>()

        for (i in 1..100) {
            val index = currentSize + i
            list.add(User(index, index.toString(), index, Date()))
        }

        return list
    }
}