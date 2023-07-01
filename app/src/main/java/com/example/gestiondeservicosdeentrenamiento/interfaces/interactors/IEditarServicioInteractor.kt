package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface IEditarServicioInteractor {
    suspend fun actualizar(servicio: Servicio)
    suspend fun obtenerServicioPorId(id: Int): Servicio
}