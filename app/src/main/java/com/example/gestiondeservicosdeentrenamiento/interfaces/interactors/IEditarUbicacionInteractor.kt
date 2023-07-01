package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion

interface IEditarUbicacionInteractor {
    suspend fun consultar(id: Int): Ubicacion
    suspend fun update(ubicacion: Ubicacion)

}