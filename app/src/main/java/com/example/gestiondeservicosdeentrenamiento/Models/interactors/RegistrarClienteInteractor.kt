package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarClientePresenter

class RegistrarClienteInteractor (presenter: IRegistrarClientePresenter, context: Context):
    IRegistrarClienteInteractor {
    private val presenter: IRegistrarClientePresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun insertarCliente(cliente: Cliente): Long {
        return operacionesDao.insertarCliente(cliente)
    }

    override suspend fun eliminar(cliente: Cliente) {
        operacionesDao.eliminarCliente(cliente)
    }

    override suspend fun insertarPersonales(datosPersonales: DatosPersonales) {
        operacionesDao.insertarPersonales(datosPersonales)
    }

    override suspend fun insertarMedicos(datosMedicos: DatosMedicos) {
        operacionesDao.insertDatosMedicos(datosMedicos)
    }

    override suspend fun insertarContacto(contacto: Contacto) {
        operacionesDao.insertContacto(contacto)
    }

    override suspend fun insertarUbicacion(ubicacion: Ubicacion) {
        operacionesDao.insertarUbicacion(ubicacion)
    }
}