package com.github.jhamin0511.diffutil.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateFormatUtil(
    pattern: String
) {

    companion object {
        const val YYYY_MM_DD = "yyyy.MM.dd"
    }

    private val format = SimpleDateFormat(pattern, Locale.getDefault())

    fun format(date: Date): String {
        return format.format(date)
    }

    fun parse(date: String): Date {
        return try {
            format.parse(date) ?: Date()
        } catch (e: ParseException) {
            Date()
        }
    }

}
