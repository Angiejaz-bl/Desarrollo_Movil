package com.example.activity.model.state
data class RegisterState(

    val nombre: String = "",
    val apellido: String = "",
    val usuario: String = "",
    val correo: String = "",
    val password: String = "",
    val mensaje: String = "",
    val registroExitoso: Boolean = false
)