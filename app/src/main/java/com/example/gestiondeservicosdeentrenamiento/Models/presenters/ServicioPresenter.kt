package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ServicioView

class ServicioPresenter (view: ServicioView, context: Context):
    IServicioPresenter {
    private var interactor: IServicioInteractor
    private var view: ServicioView

    init {
        this.view = view
        interactor = ServicioInteractor(this,context)
    }

    override suspend fun eliminar(servicio: Servicio) {
        interactor.eliminar(servicio)
    }

    override suspend fun obtenerTodosLosServicios() {
        val lista= interactor.obtenerTodosLosServicios()
        view.mostrarServicios(lista)
    }

}