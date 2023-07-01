package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

interface ISeleccionServicioPresenter {
    suspend fun consultarModalidad()
    suspend fun consultarServicioById(id: Int)
}