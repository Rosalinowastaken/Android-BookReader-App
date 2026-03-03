package com.example.validationinterfaztfg

import com.example.validationinterfaztfg.models.LibroAPI
import com.example.validationinterfaztfg.models.TipoVistaLibro

data class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val portadaUrl: String,
    val opinion: String? = null,
    val sinopsis: String? = null,
    val nickname: String? = null,
    val puntuacionUsuario: String? = null,
    var esFavorito: Boolean = false,
    var enLectura: Boolean = false,
    val paginaActual: Int? = null,
    val paginasTotales: Int? = null,
    val porcentajeLeido: Int? = null,
    val tipoVista: TipoVistaLibro = TipoVistaLibro.VISTA_PUBLICACION
) {
    constructor(libroAPI: LibroAPI) : this(
        id = libroAPI.id,
        titulo = libroAPI.titulo,
        autor = libroAPI.autor,
        categoria = libroAPI.categoria,
        portadaUrl = libroAPI.portadaUrl,
        opinion = libroAPI.opinion,
        sinopsis = libroAPI.sinopsis
    )
}
