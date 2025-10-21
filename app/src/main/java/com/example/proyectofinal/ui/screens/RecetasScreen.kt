package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Receta(
    val nombre: String,
    val ingredientes: String,
    val tipo: String,
    val imagen: Int
)




@Composable
fun RecetasScreen() {
    val recetas = obtenerRecetas() // función que retorna lista de 20 recetas

    LazyColumn {
        items(recetas) { receta ->
            RecetaItem(receta)
        }
    }
}

@Composable
fun RecetaItem(receta: Receta) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = receta.imagen),
            contentDescription = receta.nombre,
            modifier = Modifier.size(64.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = receta.nombre, style = MaterialTheme.typography.h6)
            Text(text = "Ingredientes: ${receta.ingredientes}")
            Text(text = "Tipo: ${receta.tipo}")
        }
    }
}


@Composable
fun RecetasScreen() {
    Scaffold() { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            /* lista de recetas */
            Text("Lista de Recetas más recientes", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(24.dp))




        }
    }
}

@Preview
@Composable
fun RecetasScreenPreview() {
    RecetasScreen()
}

