package com.example.validationinterfaztfg

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.validationinterfaztfg.models.TipoVistaLibro

@Composable
fun MisLibros() {
    var selectedTab by remember { mutableStateOf(0) }

    val librosLeyendo = remember {
        listOf(
            Libro(
                id = "1",
                titulo = "El Quijote",
                autor = "Miguel de Cervantes",
                categoria = "Novela",
                portadaUrl = "",
                opinion = "",
                paginasTotales = 100,
                paginaActual = 50,
                porcentajeLeido = 50,
                esFavorito = false,
                tipoVista = TipoVistaLibro.VISTA_LECTURA
            ),
            Libro(
                id = "2",
                titulo = "Cien años de soledad",
                autor = "Gabriel García Márquez",
                categoria = "Realismo mágico",
                portadaUrl = "",
                paginasTotales = 100,
                paginaActual = 75,
                porcentajeLeido = 75,
                opinion = null,
                esFavorito = false,
                tipoVista = TipoVistaLibro.VISTA_LECTURA
            )
        )
    }

    val librosGuardados = remember {
        listOf(
            Libro(
                id = "1",
                titulo = "El Quijote",
                autor = "Miguel de Cervantes",
                categoria = "Novela",
                portadaUrl = "",
                opinion = "",
                sinopsis = "Don Quijote de la Mancha es una novela escrita por el español Miguel de Cervantes Saavedra.",
                esFavorito = true,
                tipoVista = TipoVistaLibro.VISTA_GUARDADO
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
    ) {

        // Toggle buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { selectedTab = 0 },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (selectedTab == 0) Color(0xFFE0E0E0) else Color.Transparent
                )
            ) {
                Text(
                    text = "seguimiento lecturas",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }

            OutlinedButton(
                onClick = { selectedTab = 1 },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (selectedTab == 1) Color(0xFFE0E0E0) else Color.Transparent
                )
            ) {
                Text(
                    text = "libros interesantes",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Grid de libros
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (selectedTab == 0) {
                items(librosLeyendo) { libro ->
                    LibroCard(libro = libro)
                }
            } else {
                items(librosGuardados) { libro ->
                    LibroCard(libro = libro)
                }
            }
        }
    }
}



