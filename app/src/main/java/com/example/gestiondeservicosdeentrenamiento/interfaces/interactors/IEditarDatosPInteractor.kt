package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface IEditarDatosPInteractor {
    suspend fun consultar(id:Int):DatosPersonales
    suspend fun update(datosPersonales: DatosPersonales)
}