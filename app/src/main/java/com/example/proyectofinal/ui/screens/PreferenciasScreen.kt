package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinal.ui.theme.ProyectoFinalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferenciasScreen() {
    val temaState = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar (
                title = { Text("Preferencias de Usuario") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Tema", fontSize = 20.sp)
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text("Oscuro", fontSize = 16.sp)
                    Switch(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        checked = temaState.value,
                        onCheckedChange = { temaState.value = it }
                    )
                    Text("Claro", fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreferenciasScreenPreview() {
    ProyectoFinalTheme {
        PreferenciasScreen()
    }
}