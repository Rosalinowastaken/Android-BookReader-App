package com.example.pruebainterfaztfg.api

import com.example.pruebainterfaztfg.models.LibroAPI

// API Service simulado
class LibroApiService {
    suspend fun obtenerLibros(): List<LibroAPI> {
        return listOf(
            LibroAPI(
                id = "1",
                titulo = "El día que el cielo se caiga",
                autor = "Megan Maxwell",
                categoria = "Romance",
                portadaUrl = "https://static.cegal.es/imagenes/marcadas/9788408/978840816919.gif",
                opinion = "Un libro maravilloso que te atrapa desde el inicio.",
                sinopsis = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m"
            ),
            LibroAPI(
                id = "2",
                titulo = "Cien años de soledad",
                autor = "Gabriel García Márquez",
                categoria = "Realismo Mágico",
                portadaUrl = "https://upload.wikimedia.org/wikipedia/en/9/9e/Cien_anos_de_soledad.jpg",
                opinion = "Una obra maestra del realismo mágico.",
                sinopsis = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean mwwww"
            ),
            LibroAPI(
                id = "3",
                titulo = "Harry Potter y la piedra filosofal",
                autor = "J.K. Rowling",
                categoria = "Fantasía",
                portadaUrl = "https://m.media-amazon.com/images/I/81YOuOGFCJL._AC_UF1000,1000_QL80_.jpg",
                opinion = "Un inicio mágico para una saga legendaria.",
                sinopsis = "El joven mago Harry Potter descubre el mundo de la magia."
            )
        )
    }
}
