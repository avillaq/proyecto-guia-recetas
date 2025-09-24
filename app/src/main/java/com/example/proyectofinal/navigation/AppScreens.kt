package com.example.proyectofinal.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen : AppScreens("home")
    object ResultScreen : AppScreens("result/{mensaje}")
}