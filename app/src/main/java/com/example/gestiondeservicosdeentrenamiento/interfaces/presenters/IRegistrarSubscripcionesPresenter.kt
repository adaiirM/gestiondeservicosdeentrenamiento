package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface IRegistrarSubscripcionesPresenter {
    suspend fun registrar(subscripcion: Subscripcion)
}