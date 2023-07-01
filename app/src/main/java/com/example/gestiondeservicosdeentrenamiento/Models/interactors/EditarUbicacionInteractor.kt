package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarUbicacionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarUbicacionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter

class EditarUbicacionInteractor (presenter: IEditarUbicacionPresenter, context: Context):
    IEditarUbicacionInteractor {
    private val presenter: IEditarUbicacionPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultar(id: Int): Ubicacion {
        return operacionesDao.obtenerUbicacionByIdCliente(id)
    }

    override suspend fun update(ubicacion: Ubicacion) {
        operacionesDao.actualizarUbicacion(ubicacion)
    }
}