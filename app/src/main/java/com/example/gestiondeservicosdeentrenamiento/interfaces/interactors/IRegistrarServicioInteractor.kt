package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface IRegistrarServicioInteractor {
    suspend fun insertar(servicio: Servicio)
    //suspend fun actualizar(servicio: Servicio)
    //suspend fun eliminar(servicio: Servicio)
    //suspend fun obtenerServicioPorId(id: Int): Servicio
    //suspend fun obtenerTodosLosServicios(): List<Servicio>
}