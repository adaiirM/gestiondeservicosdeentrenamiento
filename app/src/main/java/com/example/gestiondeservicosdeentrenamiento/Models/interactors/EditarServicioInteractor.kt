package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarServicioPresenter

class EditarServicioInteractor (presenter: IEditarServicioPresenter, context: Context):
    IEditarServicioInteractor {
    private val presenter: IEditarServicioPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun actualizar(servicio: Servicio) {
        operacionesDao.actualizarServicio(servicio)
    }

    override suspend fun obtenerServicioPorId(id: Int): Servicio {
        return operacionesDao.obtenerServicioPorId(id)
    }

}