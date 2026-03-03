package com.example.validationinterfaztfg


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.validationinterfaztfg.models.TipoVistaLibro

@Composable
fun LibroCard(
    libro: Libro,
    onGuardadoClick: (Libro) -> Unit = {},
    onGafasClick: (Libro) -> Unit = {},
    onQuitarLecturaClick: (Libro) -> Unit = {},
    onPublicarClick: (Libro) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F0))
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            when (libro.tipoVista) {
                TipoVistaLibro.VISTA_PUBLICACION -> VistaPublicacion(libro, onGuardadoClick, onGafasClick, onPublicarClick)
                TipoVistaLibro.VISTA_LECTURA -> VistaLectura(libro, onQuitarLecturaClick, onPublicarClick)
                TipoVistaLibro.VISTA_GUARDADO -> VistaGuardado(libro, onGuardadoClick, onGafasClick)
            }
        }
    }
}

@Composable
private fun VistaPublicacion(
    libro: Libro,
    onGuardadoClick: (Libro) -> Unit,
    onGafasClick: (Libro) -> Unit,
    onPublicarClick: (Libro) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Nickname
        libro.nickname?.let {
            Text(
                text = it,
                fontSize = 12.sp,
                color = Color(0xFF666666),
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Portada
            AsyncImage(
                model = libro.portadaUrl,
                contentDescription = "Portada del libro",
                modifier = Modifier
                    .width(120.dp)
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            // Información del libro
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                // Título
                Text(
                    text = libro.titulo,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Autor
                Text(
                    text = libro.autor,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Categoría
                Text(
                    text = libro.categoria,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )

                // Sinopsis debajo de categoría
                SinopsisInteligente(
                    titulo = libro.titulo,
                    sinopsis = libro.sinopsis
                )

                // Puntuación Usuario (solo si hay opinión)
                if (!libro.opinion.isNullOrBlank()) {
                    Text(
                        text = "puntuación usuario",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333),
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    // Opinión (altura dinámica, máximo 250 caracteres)
                    val opinionLimitada = libro.opinion.take(250)
                    Text(
                        text = opinionLimitada,
                        fontSize = 12.sp,
                        color = Color(0xFF666666),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        // Iconos (Gafas, Publicar y Corazón)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono de Gafas (lectura)
            Icon(
                painter = painterResource(
                    id = if (libro.enLectura) R.drawable.leyendosivalidation else R.drawable.validationlyendo
                ),
                contentDescription = "Marcar como leyendo",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onGafasClick(libro) }
                    .padding(end = 8.dp),
                tint = Color.Unspecified
            )

            // Corazón (guardado)
            Icon(
                painter = painterResource(
                    id = if (libro.esFavorito) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24
                ),
                contentDescription = "Guardado",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onGuardadoClick(libro) },
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun VistaLectura(
    libro: Libro,
    onQuitarLecturaClick: (Libro) -> Unit,
    onPublicarClick: (Libro) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Portada
            AsyncImage(
                model = libro.portadaUrl,
                contentDescription = "Portada del libro",
                modifier = Modifier
                    .width(120.dp)
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            // Información del libro
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                // Título
                Text(
                    text = libro.titulo,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Autor
                Text(
                    text = libro.autor,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Páginas
                Text(
                    text = "${libro.paginaActual} / ${libro.paginasTotales}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Porcentaje
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "${libro.porcentajeLeido}%",
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "leído",
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .padding(top = 4.dp)
                            .background(Color.Black)
                    )
                }
            }
        }

        // Botones (Quitar y Publicar)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón Publicar
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                contentDescription = "Publicar",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onPublicarClick(libro) },
                tint = Color.Unspecified
            )
            // Botón Quitar de lectura
            Icon(
                painter = painterResource(id = R.drawable.baseline_heart_broken_24), // Necesitarás este icono (puede ser una X o un icono de eliminar)
                contentDescription = "Quitar de lectura",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onQuitarLecturaClick(libro) }
                    .padding(end = 8.dp),
                tint = Color.Unspecified
            )


        }
    }
}

@Composable
private fun VistaGuardado(
    libro: Libro,
    onGuardadoClick: (Libro) -> Unit,
    onGafasClick: (Libro) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Portada
            AsyncImage(
                model = libro.portadaUrl,
                contentDescription = "Portada del libro",
                modifier = Modifier
                    .width(120.dp)
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            // Información del libro
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                // Título
                Text(
                    text = libro.titulo,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Autor
                Text(
                    text = libro.autor,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(top = 4.dp)
                        .background(Color.Black)
                )

                // Categoría
                Text(
                    text = libro.categoria,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )

                // Sinopsis debajo de categoría
                SinopsisInteligente(
                    titulo = libro.titulo,
                    sinopsis = libro.sinopsis
                )
            }
        }

        // Iconos (Gafas y Corazón)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono de Gafas (lectura)
            Icon(
                painter = painterResource(
                    id = if (libro.enLectura) R.drawable.leyendosivalidation else R.drawable.validationlyendo
                ),
                contentDescription = "Marcar como leyendo",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onGafasClick(libro) }
                    .padding(end = 8.dp),
                tint = Color.Unspecified
            )

            // Corazón (guardado)
            Icon(
                painter = painterResource(
                    id = if (libro.esFavorito) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24
                ),
                contentDescription = "Guardado",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onGuardadoClick(libro) },
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun SinopsisInteligente(
    titulo: String,
    sinopsis: String?
) {
    val sinopsisTexto = sinopsis ?: "No hay sinopsis disponible"
    val esLarga = sinopsisTexto.length > 100

    if (esLarga) {
        // Si es larga (>100 caracteres) -> Popup
        var mostrarDialog by remember { mutableStateOf(false) }

        Text(
            text = "+ Sinopsis",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            modifier = Modifier
                .padding(top = 8.dp)
                .clickable { mostrarDialog = true }
        )

        if (mostrarDialog) {
            SinopsisDialog(
                titulo = titulo,
                sinopsis = sinopsisTexto,
                onDismiss = { mostrarDialog = false }
            )
        }
    } else {
        // Si es corta (<=100 caracteres) -> Desplegable
        var expandida by remember { mutableStateOf(false) }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = if (expandida) "- Sinopsis" else "+ Sinopsis",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { expandida = !expandida }
            )

            AnimatedVisibility(
                visible = expandida,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = sinopsisTexto,
                    fontSize = 13.sp,
                    color = Color(0xFF555555),
                    lineHeight = 15.sp,
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun SinopsisDialog(
    titulo: String,
    sinopsis: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Sinopsis",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = sinopsis,
                    fontSize = 14.sp,
                    color = Color(0xFF555555),
                    lineHeight = 20.sp
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = "Cerrar",
                    color = Color(0xFF6200EE)
                )
            }
        },
        containerColor = Color(0xFFF5F5F0),
        shape = RoundedCornerShape(12.dp)
    )
}
