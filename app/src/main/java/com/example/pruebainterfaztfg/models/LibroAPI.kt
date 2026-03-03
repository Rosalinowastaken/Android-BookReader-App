package com.example.validationinterfaztfg.models

data class LibroAPI(
    val id: String,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val portadaUrl: String,
    val opinion: String?,
    val sinopsis: String?
)

