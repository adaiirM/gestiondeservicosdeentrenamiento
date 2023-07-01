package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.SeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISeleccionClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SeleccionClienteView

class SeleccionClientePresenter (view: SeleccionClienteView, context: Context):
    ISeleccionClientePresenter {
    private var interactor: ISeleccionClienteInteractor
    private var view: SeleccionClienteView

    init {
        this.view = view
        interactor = SeleccionClienteInteractor(this,context)
    }

    override suspend fun obtenerTodosLosDatosPersonales() {
        view.mostrar(interactor.obtenerTodosLosDatosPersonales())
    }
}