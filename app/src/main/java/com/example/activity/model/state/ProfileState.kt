package com.example.activity.model.state
import android.graphics.Bitmap
data class ProfileState(

    val fotoPerfil: Bitmap? = null,
    val nombre: String = "",
    val apellido: String = "",
    val usuario: String = "",
    val correo: String = ""

)