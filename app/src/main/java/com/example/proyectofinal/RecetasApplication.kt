package com.example.proyectofinal

import android.app.Application
import com.example.proyectofinal.data.AppContainer

class RecetasApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}