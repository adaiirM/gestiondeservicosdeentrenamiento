package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto

interface IEditarContactoPresenter {
    suspend fun consultar(id: Int)
    suspend fun update(contacto: Contacto)
}