package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface RegistrarServicioView {
    suspend fun mostrarServicioPorId(servicio: Servicio)
    suspend fun mostrarTodosLosServicios(lis: List<Servicio>)
}