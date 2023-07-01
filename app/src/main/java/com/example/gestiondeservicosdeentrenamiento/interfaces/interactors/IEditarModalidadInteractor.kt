package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IEditarModalidadInteractor {
    suspend fun obtenerModalidadPorId(id: Int): Modalidad
    suspend fun actualizar(modalidad: Modalidad)
}