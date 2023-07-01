package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.SeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.SeleccionServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionServicioInterator
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SeleccionClienteView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SeleccionServicioView

class SeleccionServicioPresenter (view: SeleccionServicioView, context: Context):
    ISeleccionServicioPresenter {
    private var interactor: ISeleccionServicioInterator
    private var view: SeleccionServicioView

    init {
        this.view = view
        interactor = SeleccionServicioInteractor(this,context)
    }

    override suspend fun consultarModalidad() {
        view.mostrarLista(interactor.consultarModalidad())
    }

    override suspend fun consultarServicioById(id: Int) {
        view.mostrarServicioById(interactor.consultarServicioById(id))
    }
}