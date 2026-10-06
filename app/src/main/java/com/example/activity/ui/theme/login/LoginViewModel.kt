package com.example.activity.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity.data.repository.AuthRepository
import com.example.activity.model.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = AuthRepository()

    private val _state = MutableStateFlow(LoginState())

    val state: StateFlow<LoginState> = _state

    fun onUsuarioChange(nuevoUsuario: String) {
        _state.value = _state.value.copy(
            usuario = nuevoUsuario
        )
    }

    fun onPasswordChange(nuevoPassword: String) {
        _state.value = _state.value.copy(
            password = nuevoPassword
        )
    }

    fun onLoginClick() {

        viewModelScope.launch {

            val resultado = repository.login(
                _state.value.usuario,
                _state.value.password
            )

            resultado.onSuccess { response ->

                val data = response.data

                if (data != null) {

                    _state.value = _state.value.copy(
                        loginExitoso = true,
                        mensaje = response.message,
                        token = data.token,
                        nombre = data.user.nombre,
                        apellido = data.user.apellido,
                        correo = data.user.correo
                    )

                } else {

                    _state.value = _state.value.copy(
                        loginExitoso = false,
                        mensaje = "No se recibieron los datos del usuario"
                    )
                }

            }.onFailure { error ->

                _state.value = _state.value.copy(
                    loginExitoso = false,
                    mensaje = error.message ?: "Error al iniciar sesión"
                )
            }
        }
    }

    fun limpiarLogin() {
        _state.value = _state.value.copy(
            loginExitoso = false
        )
    }
}