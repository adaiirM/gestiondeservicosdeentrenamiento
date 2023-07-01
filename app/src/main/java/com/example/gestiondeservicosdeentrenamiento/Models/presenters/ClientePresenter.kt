package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ClienteView

class ClientePresenter (view: ClienteView, context: Context):
    IClientePresenter {
    private var interactor: IClienteInteractor
    private var view: ClienteView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = ClienteInteractor(this,context)
    }

    override suspend fun obtenerTodosLosDatosPersonales() {
        var lista= interactor.obtenerTodosLosDatosPersonales()
        view.mostrarClientes(lista)
    }

    override suspend fun eliminar(datosPersonales: DatosPersonales) {
        interactor.eliminar(datosPersonales)
    }

    override suspend fun eliminar(datosMedicos: DatosMedicos) {
        interactor.eliminar(datosMedicos)
    }

    override suspend fun eliminar(cliente: Cliente) {
        interactor.eliminar(cliente)
    }

    override suspend fun eliminar(contacto: Contacto) {
        interactor.eliminar(contacto)
    }

    override suspend fun eliminar(ubicacion: Ubicacion) {
        interactor.eliminar(ubicacion)
    }
}