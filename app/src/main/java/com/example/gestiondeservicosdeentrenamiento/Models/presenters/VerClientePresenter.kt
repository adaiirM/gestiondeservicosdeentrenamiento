package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.VerClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IVerClienteInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IVerClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ModalidadesView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.VerClienteView

class VerClientePresenter (view: VerClienteView, context: Context):
    IVerClientePresenter {
    private var interactor: IVerClienteInteractor
    private var view: VerClienteView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = VerClienteInteractor(this,context)
    }

    override suspend fun consultarDatosPErsonales(id: Int) {
        var dato= interactor.consultarDatosPErsonales(id)
        view.mostrarDatosPersonales(dato)
    }

    override suspend fun consultarContacto(id: Int) {
        var dato= interactor.consultarContacto(id)
        view.mostrarContacto(dato)
    }
}