package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionServicioInterator
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionServicioPresenter

class SeleccionServicioInteractor (presenter: ISeleccionServicioPresenter, context: Context):
    ISeleccionServicioInterator {
    private val presenter: ISeleccionServicioPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultarModalidad(): List<Modalidad> {
        return operacionesDao.obtenerTodasLasModalidades()
    }

    override suspend fun consultarServicioById(id: Int): Servicio {
        return operacionesDao.obtenerServicioPorId(id)
    }
}