package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarDatosPInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosPPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter

class EditarDatosPInteractor (presenter: IEditarDatosPPresenter, context: Context):
    IEditarDatosPInteractor {
    private val presenter: IEditarDatosPPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultar(id: Int): DatosPersonales {
        return operacionesDao.obtenerDatosPByIdCliente(id)
    }

    override suspend fun update(datosPersonales: DatosPersonales) {
       operacionesDao.actualizarPersonales(datosPersonales)
    }
}