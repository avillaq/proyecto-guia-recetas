package com.example.proyectofinal

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinal.navigation.AppNavigation
import com.example.proyectofinal.store.ThemeRepository
import com.example.proyectofinal.store.ThemeType
import com.example.proyectofinal.ui.theme.ProyectoFinalTheme

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val themeRepository = ThemeRepository(dataStore)
        setContent {
            val themeType by themeRepository.themeTypeActual.collectAsState(initial = ThemeType.LIGHT)
            val useDarkTheme = when (themeType) {
                ThemeType.LIGHT -> false
                ThemeType.DARK -> true
            }

            ProyectoFinalTheme(darkTheme = useDarkTheme) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AppNavigation(navController)
                }
            }
        }
    }
}