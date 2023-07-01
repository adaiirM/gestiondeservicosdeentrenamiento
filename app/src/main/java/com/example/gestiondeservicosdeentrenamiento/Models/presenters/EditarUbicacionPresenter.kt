package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarUbicacionInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarUbicacionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarUbicacionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarUbicacionView

class EditarUbicacionPresenter (view: EditarUbicacionView, context: Context):
    IEditarUbicacionPresenter {
    private var interactor: IEditarUbicacionInteractor
    private var view: EditarUbicacionView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarUbicacionInteractor(this,context)
    }

    override suspend fun consultar(id: Int) {
        val dato=interactor.consultar(id)
        view.mostrar(dato)
    }

    override suspend fun update(ubicacion: Ubicacion) {
        interactor.update(ubicacion)
    }
}