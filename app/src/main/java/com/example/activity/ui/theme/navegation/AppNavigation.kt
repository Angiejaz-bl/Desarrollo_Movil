package com.example.activity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.activity.ui.login.LoginScreen
import com.example.activity.ui.profile.ProfileScreen
import com.example.activity.ui.register.RegisterScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    var nombre = ""
    var apellido = ""
    var usuario = ""
    var correo = ""

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(

                onLoginSuccess = {
                        nombreUsuario,
                        apellidoUsuario,
                        usuarioLogueado,
                        correoUsuario ->

                    nombre = nombreUsuario
                    apellido = apellidoUsuario
                    usuario = usuarioLogueado
                    correo = correoUsuario

                    navController.navigate("profile")
                },

                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {

            RegisterScreen(

                onRegisterSuccess = {

                    navController.navigate("login") {

                        popUpTo("register") {
                            inclusive = true
                        }
                    }
                },

                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("profile") {

            ProfileScreen(

                nombre = nombre,
                apellido = apellido,
                usuario = usuario,
                correo = correo,

                onLogoutClick = {

                    navController.navigate("login") {

                        popUpTo("profile") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}