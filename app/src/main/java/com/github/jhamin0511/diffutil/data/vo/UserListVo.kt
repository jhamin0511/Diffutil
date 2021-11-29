package com.github.jhamin0511.diffutil.data.vo

data class UserListVo(
    val id: Int,
    val name: String,
    val age: Int,
    val date: String
) : UserItem(UserViewType.LIST)
