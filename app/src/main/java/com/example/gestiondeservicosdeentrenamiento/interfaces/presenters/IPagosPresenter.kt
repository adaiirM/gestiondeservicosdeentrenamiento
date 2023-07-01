package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

interface IPagosPresenter {
    suspend fun consultar(id: Int)
    suspend fun consultarDatosPersonalesByIdCliente(id: Int)
    suspend fun consultarModalidadById(id:Int)
    suspend fun consultarServicioByIdModalidad(id: Int)
}