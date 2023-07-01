package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.PagosInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IPagosInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IPagosPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.PagosView

class PagosPresenter (view: PagosView, context: Context):
    IPagosPresenter {
    private var interactor: IPagosInteractor
    private var view: PagosView

    init {
        this.view = view
        interactor = PagosInteractor(this,context)
    }

    override suspend fun consultar(id: Int) {
        val dato= interactor.consultar(id)
        view.mostra(dato)
    }

    override suspend fun consultarDatosPersonalesByIdCliente(id: Int) {
        view.mostrarDatosPersonales(interactor.consultarDatosPersonalesByIdCliente(id))
    }

    override suspend fun consultarModalidadById(id: Int) {
        view.mostrarModalidad(interactor.consultarModalidadById(id))
    }

    override suspend fun consultarServicioByIdModalidad(id: Int) {
        view.mostrarServicio(interactor.consultarServicioByIdModalidad(id))
    }


}