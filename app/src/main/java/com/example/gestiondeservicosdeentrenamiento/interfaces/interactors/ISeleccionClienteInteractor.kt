package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface ISeleccionClienteInteractor {
    suspend fun obtenerTodosLosDatosPersonales(): List<DatosPersonales>
}