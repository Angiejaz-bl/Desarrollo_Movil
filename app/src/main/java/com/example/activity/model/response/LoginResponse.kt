package com.example.activity.model.response
data class LoginResponse(

    val success: Boolean,
    val message: String,
    val data: LoginBody?
)