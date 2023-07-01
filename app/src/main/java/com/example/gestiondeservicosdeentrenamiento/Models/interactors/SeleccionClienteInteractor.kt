package com.example.gestiondeservicosdeentrenamiento.Models.interactors

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.repository.Repository
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter

class SeleccionClienteInteractor (presenter: ISeleccionClientePresenter, context: Context):
    ISeleccionClienteInteractor {
    private val presenter: ISeleccionClientePresenter
    private val operacionesDao: Repository

    init {
        this.presenter = presenter
        Repository.inicializar(context)
        operacionesDao= Repository.get()
    }

    override suspend fun obtenerTodosLosDatosPersonales(): List<DatosPersonales> {
        return operacionesDao.obtenerTodosLosDatosPersonales()
    }
}