package com.example.ejecicio.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Cliente {
    companion object Static{
        fun getCliente(url: String): Retrofit {
            return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }

}