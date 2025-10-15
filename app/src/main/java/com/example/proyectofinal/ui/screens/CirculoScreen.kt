package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CirculoScreen() {
    val escalaMinima = 1f
    val escalaMaxima = 3.5f


    Scaffold() { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // circulo
            Canvas (modifier = Modifier.size(100.dp).scale(1f)) {
                drawCircle(Color.Red)
            }

            // botones
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button (onClick = { // animar circulo
                    /**/
                }) {
                    Text(text = "Animar", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row (
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button (onClick = { // reducir tamaño
                        /**/
                    }) {
                        Text(text = "-", fontSize = 24.sp)
                    }
                    Button (onClick = { // aumentar tamaño
                        /**/
                    }) {
                        Text("+", fontSize = 24.sp)
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun CirculoScreenPreview() {
    CirculoScreen()
}

