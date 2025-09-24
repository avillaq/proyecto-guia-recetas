package com.example.proyectofinal.navigation

sealed class AppScreens(val route: String) {
    object Home : AppScreens("home")
    object Result : AppScreens("result/{mensaje}")
}