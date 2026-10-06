package com.example.activity.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity.data.repository.AuthRepository
import com.example.activity.model.state.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository = AuthRepository()

    private val _state = MutableStateFlow(RegisterState())

    val state: StateFlow<RegisterState> = _state

    fun onNombreChange(valor: String) {
        _state.value = _state.value.copy(
            nombre = valor
        )
    }

    fun onApellidoChange(valor: String) {
        _state.value = _state.value.copy(
            apellido = valor
        )
    }

    fun onUsuarioChange(valor: String) {
        _state.value = _state.value.copy(
            usuario = valor
        )
    }

    fun onCorreoChange(valor: String) {
        _state.value = _state.value.copy(
            correo = valor
        )
    }

    fun onPasswordChange(valor: String) {
        _state.value = _state.value.copy(
            password = valor
        )
    }

    fun onRegisterClick() {

        if (
            _state.value.nombre.isBlank() ||
            _state.value.apellido.isBlank() ||
            _state.value.usuario.isBlank() ||
            _state.value.correo.isBlank() ||
            _state.value.password.isBlank()
        ) {

            _state.value = _state.value.copy(
                registroExitoso = false,
                mensaje = "Todos los campos son obligatorios"
            )

            return
        }

        viewModelScope.launch {

            val resultado = repository.register(
                nombre = _state.value.nombre,
                apellido = _state.value.apellido,
                usuario = _state.value.usuario,
                correo = _state.value.correo,
                password = _state.value.password
            )

            resultado.onSuccess { response ->

                _state.value = _state.value.copy(
                    registroExitoso = true,
                    mensaje = response.message
                )

            }.onFailure { error ->

                _state.value = _state.value.copy(
                    registroExitoso = false,
                    mensaje = error.message ?: "Error al registrarse"
                )
            }
        }
    }
}