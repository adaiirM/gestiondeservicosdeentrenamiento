package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarModalidadPresenter

class RegistrarModalidadInteractor (presenter: IRegistrarModalidadPresenter, context: Context):
    IRegistrarModalidadInteractor {
    private val presenter: IRegistrarModalidadPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun insertar(modalidad: Modalidad) {
        operacionesDao.insertarModalidad(modalidad)
    }
}