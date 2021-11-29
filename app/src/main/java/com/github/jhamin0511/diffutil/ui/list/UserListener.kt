package com.github.jhamin0511.diffutil.ui.list

interface UserListener {

    fun onClickHolder(id: Int)

    fun onLongClickHolder(id: Int): Boolean = false

}
