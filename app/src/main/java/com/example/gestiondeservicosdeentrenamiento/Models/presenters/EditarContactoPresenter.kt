package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarContactoInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarContadoInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarContactoPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarContactoView

class EditarContactoPresenter (view: EditarContactoView, context: Context):
    IEditarContactoPresenter {
    private var interactor: IEditarContadoInteractor
    private var view: EditarContactoView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarContactoInteractor(this,context)
    }

    override suspend fun consultar(id: Int) {
        var dato= interactor.consultar(id)
        view.mostrarDato(dato)
    }

    override suspend fun update(contacto: Contacto) {
        interactor.update(contacto)
    }
}