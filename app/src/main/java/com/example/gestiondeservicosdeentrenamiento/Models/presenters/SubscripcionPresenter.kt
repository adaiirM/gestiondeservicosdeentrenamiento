package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.SubscripcionIntercator
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SubscripcionView

class SubscripcionPresenter (view: SubscripcionView, context: Context):
    ISubscripcionPresenter {
    private var interactor: ISubscripcionInteractor
    private var view: SubscripcionView

    init {
        this.view = view
        interactor = SubscripcionIntercator(this,context)
    }

    override suspend fun consultar() {
        val dato= interactor.consultar()
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

    override suspend fun cambiar(subscripcion: Subscripcion) {
        interactor.cambiar(subscripcion)
    }

    override suspend fun cancelar(subscripcion: Subscripcion) {
        interactor.cancelar(subscripcion)
    }


}