package com.example.activity.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.activity.ui.theme.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    nombre: String,
    apellido: String,
    usuario: String,
    correo: String,
    onLogoutClick: () -> Unit,
    profileViewModel: ProfileViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val state by profileViewModel.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Nombre: $nombre"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Apellido: $apellido"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Usuario: $usuario"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Correo: $correo"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onLogoutClick
        ) {
            Text("Cerrar sesión")
        }
    }
}