package com.example.activity.model.response
data class StandardResponse(

    val success: Boolean,
    val message: String,
    val data: UserResponse?
)