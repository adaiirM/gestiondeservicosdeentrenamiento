package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion

interface IEditarUbicacionPresenter {
    suspend fun consultar(id: Int)
    suspend fun update(ubicacion: Ubicacion)
}