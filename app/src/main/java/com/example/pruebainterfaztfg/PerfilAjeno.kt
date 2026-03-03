package com.example.pruebainterfaztfg

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerfilAjeno(
    nickname: String = "UsuarioEjemplo",
    nrViews: Int = 0,
    seguidores: Int = 456,
    seguidos: Int = 128,
    onSeguirClick: () -> Unit = {},
    estaSiguiendo: Boolean = false
) {
    var siguiendo by remember { mutableStateOf(estaSiguiendo) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
    ) {
        // Header con foto de perfil y nickname
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Foto de perfil (círculo blanco por ahora)
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Nickname
            Text(
                text = nickname,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem(label = "NReviews", value = nrViews.toString())
            StatItem(label = "Seguidores", value = seguidores.toString())
            StatItem(label = "Seguidos", value = seguidos.toString())
        }

        // Botón Seguir/Dejar de seguir
        Button(
            onClick = {
                siguiendo = !siguiendo
                onSeguirClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (siguiendo) Color(0xFFC45858) else Color(0xFF69C26D)
            )
        ) {
            Text(
                text = if (siguiendo) "Dejar de seguir" else "Seguir",
                fontSize = 16.sp,
                color = Color.White
            )
        }

        // Título "Sugerencias"
        Text(
            text = "Sugerencias",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        Divider(
            color = Color(0xFFCCCCCC),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Grid de publicaciones
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(12) { index ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Publicación",
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
private fun StatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}