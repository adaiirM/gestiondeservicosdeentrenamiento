package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarDatosPInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarDatosPInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosPPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarDatosPView

class EditarDatosPPresenter (view: EditarDatosPView, context: Context):
    IEditarDatosPPresenter {
    private var interactor: IEditarDatosPInteractor
    private var view: EditarDatosPView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarDatosPInteractor(this,context)
    }

    override suspend fun consultar(id: Int) {
        var daro=interactor.consultar(id)
        view.mostrarDatos(daro)
    }

    override suspend fun update(datosPersonales: DatosPersonales) {
        interactor.update(datosPersonales)
    }
}