package com.example.pruebainterfaztfg

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebainterfaztfg.models.TipoVistaLibro

@Composable
fun Busqueda() {
    var searchText by remember { mutableStateOf("") }

    val libros = remember {
        listOf(
            Libro(
                id = "1",
                titulo = "El Quijote",
                autor = "Miguel de Cervantes",
                categoria = "Novela",
                portadaUrl = "",
                opinion = "",
                sinopsis = "Don Quijote de la Mancha es una novela escrita por el español Miguel de Cervantes Saavedra.",
                esFavorito = false,
                tipoVista = TipoVistaLibro.VISTA_PUBLICACION
            ),
            Libro(
                id = "2",
                titulo = "Cien años de soledad",
                autor = "Gabriel García Márquez",
                categoria = "Realismo mágico",
                portadaUrl = "",
                opinion = null,
                sinopsis = "La historia de la familia Buendía a lo largo de siete generaciones.",
                esFavorito = false,
                tipoVista = TipoVistaLibro.VISTA_PUBLICACION
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
    ) {
        // Barra de búsqueda
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                modifier = Modifier.size(24.dp)
            )

            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Buscar") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            IconButton(onClick = { /* Cambiar a perfiles */ }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil"
                )
            }
        }

        HorizontalDivider(thickness = 1.dp, color = Color(0xFFCCCCCC))

        // Lista de libros
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(libros) { libro ->
                LibroCard(libro = libro)
            }
        }
    }
}
