package com.example.proyectofinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyectofinal.ui.screens.AdaptativoScreen
import com.example.proyectofinal.ui.screens.CirculoScreen
import com.example.proyectofinal.ui.screens.HomeScreen
import com.example.proyectofinal.ui.screens.ResultScreen
import com.example.proyectofinal.ui.screens.FormularioScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreens.Circulo.route) {
        composable(
            route = AppScreens.Home.route // ruta "/home"
        ) {
            // ruta que lleva a HomeScreen
            HomeScreen(onNavigate = { mensaje: String ->
                navController.navigate("result/$mensaje")
            })
        }
        composable(
            route = AppScreens.Adaptativo.route // ruta "/adaptativo"
        ) {
            AdaptativoScreen()
        }
        composable(
            route = AppScreens.Formulario.route // ruta "/registro"
        ) {
            FormularioScreen(onNavigate = { mensaje: String ->
                navController.navigate("result/$mensaje")
            })
        }
        composable(
            route = AppScreens.Circulo.route // ruta "/circulo"
        ) {
            CirculoScreen()
        }
        composable(
            route = AppScreens.Result.route, // ruta "result/{mensaje}"
            arguments = listOf(navArgument("mensaje") { type = NavType.StringType })
        ) { backStackEntry ->
            // capturamos el mensaje del parametro
            val mensaje = backStackEntry.arguments?.getString("mensaje") ?: ""
            // ruta que lleva a ResultScreen
            ResultScreen(
                mensaje = mensaje,
                onNavigate = {
                    navController.popBackStack()
                }
            )
        }
    }
}
