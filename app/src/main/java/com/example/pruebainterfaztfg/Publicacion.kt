package com.example.pruebainterfaztfg

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Publicacion() {
    var titulo by remember { mutableStateOf("") }
    var autor by remember { mutableStateOf("") }
    var paginaActual by remember { mutableStateOf("") }
    var paginasTotales by remember { mutableStateOf("") }
    var porcentaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Portada
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(280.dp)
                .background(Color.Black)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Campo Título
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "título",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            TextField(
                value = titulo,
                onValueChange = { titulo = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Autor
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "autor",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            TextField(
                value = autor,
                onValueChange = { autor = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Páginas
        Text(
            text = "pág Actual / págTOTALES",
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = paginaActual,
                onValueChange = { paginaActual = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Text(text = "/", fontSize = 18.sp)

            OutlinedTextField(
                value = paginasTotales,
                onValueChange = { paginasTotales = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Porcentaje
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "porcentaje leído",
                fontSize = 14.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = porcentaje,
                onValueChange = { porcentaje = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("0%") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}