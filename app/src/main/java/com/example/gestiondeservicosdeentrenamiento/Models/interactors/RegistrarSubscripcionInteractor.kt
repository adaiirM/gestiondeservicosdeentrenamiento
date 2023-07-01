package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistraSubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarSubscripcionesPresenter

class RegistrarSubscripcionInteractor (presenter: IRegistrarSubscripcionesPresenter, context: Context):
    IRegistraSubscripcionInteractor {
    private val presenter: IRegistrarSubscripcionesPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun registrar(subscripcion: Subscripcion) {
        operacionesDao.insertarSubscripcion(subscripcion)
    }
}