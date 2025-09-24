package com.example.proyectofinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyectofinal.ui.screens.HomeScreen
import com.example.proyectofinal.ui.screens.ResultScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreens.Home.route) {
        composable(
            route = AppScreens.Home.route // ruta "home/"
        ) {
            // ruta que lleva a HomeScreen
            HomeScreen(onNavigate = { mensaje: String ->
                navController.navigate("result/$mensaje")
            })
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
