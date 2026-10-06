package com.example.activity.ui.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


// construye la interfaz utilizando Jetpack Compose
@Composable
fun RegisterScreen(

    // Obtenemos el RegisterViewModel que manejará la lógica del registro.
    registerViewModel: RegisterViewModel = viewModel(),

    // Función que se ejecutará cuando el registro sea exitoso.
    onRegisterSuccess: () -> Unit,
    // Función para regresar al Login.
    onBackToLogin: () -> Unit
) {

    // Obtenemos el estado actual del RegisterViewModel.
    val state by registerViewModel.state.collectAsState()

    // Column organiza todos los elementos verticalmente.
    Column(

        // La columna ocupa toda la pantalla y agrega 32dp de espacio alrededor.
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),

        // Centra los elementos verticalmente.
        verticalArrangement = Arrangement.Center,

        // Centra los elementos horizontalmente.
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // Título de la pantalla.
        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineMedium
        )

        // Espacio de 24dp.
        Spacer(modifier = Modifier.height(24.dp))


        // Campo para escribir el nombre.
        OutlinedTextField(
            value = state.nombre,

            // Cuando cambia el nombre enviamos el nuevo valor al ViewModel
            onValueChange = {
                registerViewModel.onNombreChange(it)
            },

            label = {
                Text("Nombre")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(12.dp))

        // Campo para escribir el apellido.
        OutlinedTextField(
            value = state.apellido,

            onValueChange = {
                registerViewModel.onApellidoChange(it)
            },

            label = {
                Text("Apellido")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(12.dp))


        // Campo para escribir el usuario
        OutlinedTextField(
            value = state.usuario,

            onValueChange = {
                registerViewModel.onUsuarioChange(it)
            },

            label = {
                Text("Usuario")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(12.dp))


        // Campo para escribir el correo
        OutlinedTextField(
            value = state.correo,

            onValueChange = {
                registerViewModel.onCorreoChange(it)
            },

            label = {
                Text("Correo")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(12.dp))


        // Campo para escribir la contraseña
        OutlinedTextField(
            value = state.password,

            onValueChange = {
                registerViewModel.onPasswordChange(it)
            },

            label = {
                Text("Contraseña")
            },

            // Oculta visualmente la contraseña
            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(20.dp))


        // Boton para crear la cuenta
        Button(
            onClick = {

                // Cuando se presiona el botón le indicamos al ViewModel que realice el registro.
                registerViewModel.onRegisterClick()
            },

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }


        Spacer(modifier = Modifier.height(12.dp))


        // Botón para volver al Login.
        Button(

            // Ejecutamos la función recibida desde AppNavigation.
            onClick = onBackToLogin,

            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Login")
        }


        Spacer(modifier = Modifier.height(16.dp))


        // Si existe un mensaje, lo mostramos.
        if (state.mensaje.isNotEmpty()) {

            Text(
                text = state.mensaje,

                // Si el registro fue exitoso usamos el color principal.
                // Si ocurrió un error usamos el color de error.
                color = if (state.registroExitoso) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.error
                }
            )
        }


        // Si el registro fue exitoso llamamos a la función de éxito.
        if (state.registroExitoso) {
            onRegisterSuccess()
        }
    }
}