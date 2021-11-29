package com.github.jhamin0511.diffutil.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class UserDto(
    val id: Int,
    var name: String,
    var age: Int,
    var createdAt: Date
) : Parcelable
