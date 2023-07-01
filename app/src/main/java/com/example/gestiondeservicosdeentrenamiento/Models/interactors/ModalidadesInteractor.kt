package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter

class ModalidadesInteractor (presenter: IModalidadesPresenter, context: Context):
    IModalidadesInteractor {
    private val presenter: IModalidadesPresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun eliminar(modalidad: Modalidad) {
        operacionesDao.eliminarModalidad(modalidad)
    }

    override suspend fun obtenerModalidadesPorIdServicio(id: Int): List<Modalidad> {
        return operacionesDao.obtenerModalidadPorIdServicio(id)
    }

}