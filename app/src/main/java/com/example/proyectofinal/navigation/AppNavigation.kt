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
import com.example.proyectofinal.ui.screens.PreferenciasScreen
import com.example.proyectofinal.ui.screens.RecetasScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreens.Preferencias.route) {
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
            route = AppScreens.Recetas.route // ruta "/recetas"
        ) {
            RecetasScreen()
        }
        composable (
            route = AppScreens.Preferencias.route // ruta "/preferencias"
        ) {
            PreferenciasScreen()
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
