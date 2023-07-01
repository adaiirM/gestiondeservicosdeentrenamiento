package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarServicioView

class EditarServicioPresenter (view: EditarServicioView, context: Context):
    IEditarServicioPresenter {
    private var interactor: IEditarServicioInteractor
    private var view: EditarServicioView

    init {
        this.view = view
        interactor = EditarServicioInteractor(this,context)
    }

    override suspend fun actualizar(servicio: Servicio) {
        interactor.actualizar(servicio)
    }

    override suspend fun obtenerServicioPorId(id: Int) {
        var element= interactor.obtenerServicioPorId(id)
        view.mostrarServicio(element)
    }
}