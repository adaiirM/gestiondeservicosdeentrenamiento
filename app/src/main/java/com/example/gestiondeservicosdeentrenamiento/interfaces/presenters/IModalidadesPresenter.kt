package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IModalidadesPresenter {
    suspend fun obtenerModalidadesPorIdServicio(id: Int)
    suspend fun eliminar(modalidad: Modalidad)
}