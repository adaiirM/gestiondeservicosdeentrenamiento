package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IModalidadesInteractor {
    //suspend fun insertar(modalidad: Modalidad)
    // suspend fun actualizar(modalidad: Modalidad)
    suspend fun eliminar(modalidad: Modalidad)
    //suspend fun obtenerModalidadPorId(id: Int): Modalidad
    suspend fun obtenerModalidadesPorIdServicio(id: Int): List<Modalidad>
    //suspend fun obtenerTodasLasModalidades(): List<Modalidad>
}