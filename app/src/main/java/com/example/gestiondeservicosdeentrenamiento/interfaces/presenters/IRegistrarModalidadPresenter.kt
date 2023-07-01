package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IRegistrarModalidadPresenter {
    suspend fun insertar(modalidad: Modalidad)
}