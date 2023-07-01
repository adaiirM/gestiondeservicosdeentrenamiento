package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IVerClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IVerClientePresenter

class VerClienteInteractor (presenter: IVerClientePresenter, context: Context):
    IVerClienteInteractor {
    private val presenter: IVerClientePresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultarDatosPErsonales(id: Int): DatosPersonales {
        return operacionesDao.obtenerDatosPByIdCliente(id)
    }

    override suspend fun consultarContacto(id: Int): Contacto {
        return  operacionesDao.getContactoByIdCliente(id)
    }
}