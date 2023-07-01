package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto

interface IEditarContadoInteractor {
    suspend fun consultar(id: Int): Contacto
    suspend fun update(contacto: Contacto)
}