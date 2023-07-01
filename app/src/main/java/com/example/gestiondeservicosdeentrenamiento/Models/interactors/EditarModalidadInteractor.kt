package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarModalidadPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter

class EditarModalidadInteractor (presenter: IEditarModalidadPresenter, context: Context):
    IEditarModalidadInteractor {
    private val presenter: IEditarModalidadPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun obtenerModalidadPorId(id: Int): Modalidad {
        return operacionesDao.obtenerModalidadPorId(id)
    }

    override suspend fun actualizar(modalidad: Modalidad) {
        operacionesDao.actualizarModalidad(modalidad)
    }
}