package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface IRegistrarServcioPresenter {
    suspend fun insertar(servicio: Servicio)
    //suspend fun actualizar(servicio: Servicio)
    //suspend fun eliminar(servicio: Servicio)
    //suspend fun obtenerServicioPorId(id: Int)
    //suspend fun obtenerTodosLosServicios()
}