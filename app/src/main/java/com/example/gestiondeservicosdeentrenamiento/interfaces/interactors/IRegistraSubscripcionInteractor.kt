package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface IRegistraSubscripcionInteractor {
    suspend fun registrar(subscripcion: Subscripcion)
}