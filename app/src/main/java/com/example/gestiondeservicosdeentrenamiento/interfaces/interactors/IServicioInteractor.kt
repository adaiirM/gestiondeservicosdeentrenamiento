package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface IServicioInteractor {
    suspend fun eliminar(servicio: Servicio)
    suspend fun obtenerTodosLosServicios(): List<Servicio>
}