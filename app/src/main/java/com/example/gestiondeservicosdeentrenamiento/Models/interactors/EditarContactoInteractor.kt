package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarContadoInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarContactoPresenter

class EditarContactoInteractor (presenter: IEditarContactoPresenter, context: Context):
    IEditarContadoInteractor {
    private val presenter: IEditarContactoPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }


    override suspend fun consultar(id: Int): Contacto {
        return operacionesDao.getContactoByIdCliente(id)
    }

    override suspend fun update(contacto: Contacto) {
        operacionesDao.updateContacto(contacto)
    }
}