package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface IEditarDatosPPresenter {
    suspend fun consultar(id:Int)
    suspend fun update(datosPersonales: DatosPersonales)
}