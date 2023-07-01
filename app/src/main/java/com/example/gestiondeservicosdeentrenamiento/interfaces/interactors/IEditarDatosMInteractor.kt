package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos

interface IEditarDatosMInteractor {
    suspend fun consultar(id: Int): DatosMedicos
    suspend fun update(datosMedicos: DatosMedicos)
}