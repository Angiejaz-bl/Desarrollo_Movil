package com.example.activity.model.response

data class LoginBody(

    val token: String,
    val user: UserResponse
)