package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter

class SubscripcionIntercator (presenter: ISubscripcionPresenter, context: Context):
    ISubscripcionInteractor {
    private val presenter: ISubscripcionPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultar(): List<Subscripcion> {
        return operacionesDao.obtenerTodasLasSubscripciones()
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

    override suspend fun cambiar(subscripcion: Subscripcion) {
        operacionesDao.actualizarSubscripcion(subscripcion)
    }

    override suspend fun cancelar(subscripcion: Subscripcion) {
        operacionesDao.actualizarSubscripcion(subscripcion)
    }


}