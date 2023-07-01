package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ClienteView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ModalidadesView

class ClienteInteractor (presenter: IClientePresenter, context: Context):
    IClienteInteractor {
    private val presenter: IClientePresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun obtenerTodosLosDatosPersonales(): List<DatosPersonales> {
        return operacionesDao.obtenerTodosLosDatosPersonales()
    }

    override suspend fun eliminar(datosPersonales: DatosPersonales) {
        operacionesDao.eliminarPerosanles(datosPersonales)
    }

    override suspend fun eliminar(datosMedicos: DatosMedicos) {
        operacionesDao.deleteDatosMedicos(datosMedicos)
    }

    override suspend fun eliminar(cliente: Cliente) {
        operacionesDao.eliminarCliente(cliente)
    }

    override suspend fun eliminar(contacto: Contacto) {
        operacionesDao.deleteContacto(contacto)
    }

    override suspend fun eliminar(ubicacion: Ubicacion) {
        operacionesDao.eliminarUbicacion(ubicacion)
    }
}