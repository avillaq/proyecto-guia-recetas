package com.example.proyectofinal.navigation

sealed class AppScreens(val route: String) {
    object Home : AppScreens("home")
    object Result : AppScreens("result/{mensaje}")
    object Adaptativo : AppScreens("adaptativo")
    object Formulario : AppScreens("registro")
    object Circulo : AppScreens("circulo")
    object Recetas : AppScreens("recetas")
    object Preferencias : AppScreens("preferencias")

}