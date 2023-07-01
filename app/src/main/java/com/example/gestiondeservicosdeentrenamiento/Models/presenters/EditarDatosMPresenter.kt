package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarDatosMInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarDatosMInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosMPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarDatosMView

class EditarDatosMPresenter (view: EditarDatosMView, context: Context):
    IEditarDatosMPresenter {
    private var interactor: IEditarDatosMInteractor
    private var view: EditarDatosMView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarDatosMInteractor(this,context)
    }

    override suspend fun consultar(id: Int) {
        val dato= interactor.consultar(id)
        view.mostrar(dato)
    }

    override suspend fun update(datosMedicos: DatosMedicos) {
        interactor.update(datosMedicos)
    }
}