package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface IServicioPresenter {
    suspend fun eliminar(servicio: Servicio)
    suspend fun obtenerTodosLosServicios()
}