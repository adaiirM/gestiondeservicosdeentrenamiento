package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IServicioPresenter

class ServicioInteractor (presenter: IServicioPresenter, context: Context):
    IServicioInteractor {
    private val presenter: IServicioPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun eliminar(servicio: Servicio) {
        operacionesDao.eliminarServicio(servicio)
    }

    override suspend fun obtenerTodosLosServicios(): List<Servicio> {
        return operacionesDao.obtenerTodosLosServicios()
    }

}