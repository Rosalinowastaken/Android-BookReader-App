package com.example.validationinterfaztfg

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
fun Perfil() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.width(40.dp))

            IconButton(onClick = { /* Configuración */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Configuración")
            }
        }

        Text(
            text = "NICKNAME",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "LIBROS TOTALES",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "24",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "N SEGUIDOS",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "128",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "N SEGUIDORES",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "456",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFFCCCCCC)
        )

        // Grid de publicaciones (3x3)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(9) { index ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.White)
                )
            }
        }
    }
}
