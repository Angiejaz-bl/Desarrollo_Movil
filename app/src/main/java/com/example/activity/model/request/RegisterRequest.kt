package com.example.activity.model.request

data class RegisterRequest(
    val nombre: String,
    val apellido: String,
    val usuario: String,
    val correo: String,
    val password: String
)