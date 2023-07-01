package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface IRegistrarModalidadInteractor {
    suspend fun insertar(modalidad: Modalidad)
}