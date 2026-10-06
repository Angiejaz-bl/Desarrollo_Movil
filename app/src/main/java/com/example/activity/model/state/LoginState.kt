package com.example.activity.model.state
data class LoginState(


    val usuario: String = "",
    val password: String = "",
    val mensaje: String = "",
    val loginExitoso: Boolean = false,
    val token: String = "",
    val nombre: String = "",
    val apellido: String = "",
    val correo: String = ""
)