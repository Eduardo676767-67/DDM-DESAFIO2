package com.example.perfilusuario.service

import com.example.perfilusuario.model.Produto
import retrofit2.http.GET

interface ProdutoApi {
    @GET("products")
    suspend fun obterProdutos(): List<Produto>
}
