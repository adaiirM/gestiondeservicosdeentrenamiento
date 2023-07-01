package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter

class RegistrarServicioInteractor (presenter: IRegistrarServcioPresenter, context: Context):
    IRegistrarServicioInteractor {
    private val presenter: IRegistrarServcioPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun insertar(servicio: Servicio) {
        operacionesDao.insertarServicio(servicio)
    }
}