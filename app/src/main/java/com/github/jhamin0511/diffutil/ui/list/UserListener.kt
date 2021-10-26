package com.github.jhamin0511.diffutil.ui.list

import com.github.jhamin0511.diffutil.data.dto.User

interface UserListener {

    fun onClickHolder(value: User, position: Int)

    fun onLongClickHolder(value: User, position: Int): Boolean = false

}
