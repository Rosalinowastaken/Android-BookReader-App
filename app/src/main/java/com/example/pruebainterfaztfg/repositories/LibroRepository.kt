package com.example.pruebainterfaztfg.repositories

import android.content.Context

// Repository para manejar opiniones de usuario
class LibroRepository(private val context: Context) {
    private val prefs = context.getSharedPreferences("libros_prefs", Context.MODE_PRIVATE)

    fun toggleFavorito(libroId: String): Boolean {
        val esFavorito = prefs.getBoolean("favorito_$libroId", false)
        val nuevoEstado = !esFavorito
        prefs.edit().putBoolean("favorito_$libroId", nuevoEstado).apply()
        return nuevoEstado
    }

    fun esFavorito(libroId: String): Boolean {
        return prefs.getBoolean("favorito_$libroId", false)
    }

    fun toggleLectura(libroId: String): Boolean {
        val enLectura = prefs.getBoolean("lectura_$libroId", false)
        val nuevoEstado = !enLectura
        prefs.edit().putBoolean("lectura_$libroId", nuevoEstado).apply()
        return nuevoEstado
    }

    fun enLectura(libroId: String): Boolean {
        return prefs.getBoolean("lectura_$libroId", false)
    }
}