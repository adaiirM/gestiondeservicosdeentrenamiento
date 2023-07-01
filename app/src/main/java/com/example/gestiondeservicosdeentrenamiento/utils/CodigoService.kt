package com.example.ejecicio.utils

import android.telecom.Call
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Codigo
import retrofit2.http.*

interface CodigoService {
    @GET("list")
    fun getCodigo(): retrofit2.Call<List<Codigo>>

    @POST("add")
    fun addCodigo(@Body codigo: Codigo):retrofit2.Call<Codigo>

    @POST("update/{id}")
    fun updateCodigo(@Body codigo:Codigo, @Part("id") id: Int):retrofit2.Call<Codigo>

    @POST("delete/{id}")
    fun deleteCodigo(@Path("id") id: Int):retrofit2.Call<Codigo>
}