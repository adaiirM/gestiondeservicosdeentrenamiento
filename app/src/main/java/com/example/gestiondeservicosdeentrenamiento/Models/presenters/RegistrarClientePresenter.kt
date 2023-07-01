package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.RegistrarClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarClienteView

class RegistrarClientePresenter (view: RegistrarClienteView, context: Context):
    IRegistrarClientePresenter {
    private var interactor: IRegistrarClienteInteractor
    private var view: RegistrarClienteView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistrarClienteInteractor(this,context)
    }

    override suspend fun insertarCliente(cliente: Cliente) {
        val dato= interactor.insertarCliente(cliente)
        view.mostarIdCliente(dato)
    }

    override suspend fun eliminar(cliente: Cliente) {
        interactor.eliminar(cliente)
    }

    override suspend fun insertarPersonales(datosPersonales: DatosPersonales) {
        interactor.insertarPersonales(datosPersonales)
    }

    override suspend fun insertarMedicos(datosMedicos: DatosMedicos) {
        interactor.insertarMedicos(datosMedicos)
    }

    override suspend fun insertarContacto(contacto: Contacto) {
        interactor.insertarContacto(contacto)
    }

    override suspend fun insertarUbicacion(ubicacion: Ubicacion) {
        interactor.insertarUbicacion(ubicacion)
    }

}