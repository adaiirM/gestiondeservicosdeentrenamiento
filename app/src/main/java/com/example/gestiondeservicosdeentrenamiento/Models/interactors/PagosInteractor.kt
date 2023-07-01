package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IPagosInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IPagosPresenter

class PagosInteractor (presenter: IPagosPresenter, context: Context):
    IPagosInteractor {
    private val presenter: IPagosPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultar(id: Int): List<Subscripcion> {
        return operacionesDao.obtenerTodasLasSubscripcionesByIdEstado(id)
    }

    override suspend fun consultarDatosPersonalesByIdCliente(id: Int): DatosPersonales {
        return operacionesDao.obtenerDatosPByIdCliente(id)
    }

    override suspend fun consultarModalidadById(id: Int): Modalidad {
        return operacionesDao.obtenerModalidadPorId(id)
    }

    override suspend fun consultarServicioByIdModalidad(id: Int): Servicio {
        return operacionesDao.obtenerServicioPorId(id)
    }

}