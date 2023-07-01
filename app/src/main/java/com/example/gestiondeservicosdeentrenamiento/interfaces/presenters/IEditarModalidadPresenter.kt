package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IEditarModalidadPresenter {
    suspend fun obtenerModalidadPorId(id: Int)
    suspend fun actualizar(modalidad: Modalidad)
}