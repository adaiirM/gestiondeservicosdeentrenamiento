package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface ISubscripcionPresenter {
    suspend fun consultar()
    suspend fun consultarDatosPersonalesByIdCliente(id: Int)
    suspend fun consultarModalidadById(id:Int)
    suspend fun consultarServicioByIdModalidad(id: Int)

    suspend fun cambiar(subscripcion: Subscripcion)
    suspend fun cancelar(subscripcion: Subscripcion)
}