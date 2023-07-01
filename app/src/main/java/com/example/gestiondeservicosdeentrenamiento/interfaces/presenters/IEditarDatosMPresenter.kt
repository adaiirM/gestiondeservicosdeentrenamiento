package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos

interface IEditarDatosMPresenter {
    suspend fun consultar(id: Int)
    suspend fun update(datosMedicos: DatosMedicos)
}