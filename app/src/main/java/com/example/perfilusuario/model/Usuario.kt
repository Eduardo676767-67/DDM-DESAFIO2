package com.example.perfilusuario.model

data class Usuario(
    val uid: String = "",
    val nome: String = "",
    val email: String = "",
    val dataCriacao: Long = System.currentTimeMillis()
)
