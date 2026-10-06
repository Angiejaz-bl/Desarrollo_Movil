package com.example.activity.ui.theme.profile

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.example.activity.model.state.ProfileState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.ByteArrayOutputStream

class ProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state

    fun onFotoTomada(bitmap: Bitmap) {
        _state.value = _state.value.copy(
            fotoPerfil = bitmap
        )
    }

    fun obtenerFotoEnByte(): ByteArray {
        val bitmap = _state.value.fotoPerfil ?: return ByteArray(0)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        return stream.toByteArray()
    }

    fun cargarFotoDesdeBytes(bytes: ByteArray) {
    }
}