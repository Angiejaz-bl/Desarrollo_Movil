package com.example.activity.data.repository

import com.example.activity.data.remote.RetrofitClient
import com.example.activity.model.request.LoginRequest
import com.example.activity.model.request.RegisterRequest
import com.example.activity.model.response.LoginResponse
import com.example.activity.model.response.StandardResponse
import com.google.gson.Gson

class AuthRepository {

    private val gson = Gson()

    suspend fun login(
        usuario: String,
        password: String
    ): Result<LoginResponse> {

        return try {

            val response = RetrofitClient.apiService.login(
                LoginRequest(
                    usuario = usuario,
                    password = password
                )
            )

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(
                        Exception("Respuesta vacía del servidor")
                    )
                }

            } else {

                val errorBody = response.errorBody()?.string()

                if (errorBody != null) {

                    try {

                        val errorResponse = gson.fromJson(
                            errorBody,
                            StandardResponse::class.java
                        )

                        Result.failure(
                            Exception(errorResponse.message)
                        )

                    } catch (e: Exception) {

                        Result.failure(
                            Exception(errorBody)
                        )
                    }

                } else {

                    Result.failure(
                        Exception("Error en el servidor")
                    )
                }
            }

        } catch (e: Exception) {

            Result.failure(
                Exception(e.message ?: "Error de conexión")
            )
        }
    }

    suspend fun register(
        nombre: String,
        apellido: String,
        usuario: String,
        correo: String,
        password: String
    ): Result<StandardResponse> {

        return try {

            val response = RetrofitClient.apiService.register(
                RegisterRequest(
                    nombre = nombre,
                    apellido = apellido,
                    usuario = usuario,
                    correo = correo,
                    password = password
                )
            )

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(
                        Exception("Respuesta vacía del servidor")
                    )
                }

            } else {

                val errorBody = response.errorBody()?.string()

                if (errorBody != null) {

                    try {

                        val errorResponse = gson.fromJson(
                            errorBody,
                            StandardResponse::class.java
                        )

                        Result.failure(
                            Exception(errorResponse.message)
                        )

                    } catch (e: Exception) {

                        Result.failure(
                            Exception(errorBody)
                        )
                    }

                } else {

                    Result.failure(
                        Exception("Error en el servidor")
                    )
                }
            }

        } catch (e: Exception) {

            Result.failure(
                Exception(e.message ?: "Error de conexión")
            )
        }
    }
}