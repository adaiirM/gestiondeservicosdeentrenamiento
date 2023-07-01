package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarDatosMInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosMPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter

class EditarDatosMInteractor (presenter: IEditarDatosMPresenter, context: Context):
    IEditarDatosMInteractor {
    private val presenter: IEditarDatosMPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun consultar(id: Int): DatosMedicos {
        return operacionesDao.getDatosMedicosByIdClinete(id)
    }

    override suspend fun update(datosMedicos: DatosMedicos) {
        operacionesDao.updateDatosMedicos(datosMedicos)
    }
}