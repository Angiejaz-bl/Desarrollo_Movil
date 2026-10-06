package com.example.activity.data.remote

import com.example.activity.model.request.LoginRequest
import com.example.activity.model.request.RegisterRequest
import com.example.activity.model.response.LoginResponse
import com.example.activity.model.response.StandardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @POST("api/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<StandardResponse>
}