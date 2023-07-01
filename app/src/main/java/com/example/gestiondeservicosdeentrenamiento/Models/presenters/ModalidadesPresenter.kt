package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.RegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ModalidadesView

class ModalidadesPresenter (view: ModalidadesView, context: Context):
    IModalidadesPresenter {
    private var interactor: IModalidadesInteractor
    private var view: ModalidadesView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = ModalidadesInteractor(this,context)
    }

    override suspend fun obtenerModalidadesPorIdServicio(id: Int) {
        val list= interactor.obtenerModalidadesPorIdServicio(id)
        view.mostarModalidades(list)
    }

    override suspend fun eliminar(modalidad: Modalidad) {
        interactor.eliminar(modalidad)
    }

}