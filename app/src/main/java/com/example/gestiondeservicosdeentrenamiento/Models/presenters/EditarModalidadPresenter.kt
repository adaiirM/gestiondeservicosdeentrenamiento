package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.EditarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.ModalidadesInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IEditarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarModalidadPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarModalidadView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ModalidadesView

class EditarModalidadPresenter (view: EditarModalidadView, context: Context):
    IEditarModalidadPresenter {
    private var interactor: IEditarModalidadInteractor
    private var view: EditarModalidadView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = EditarModalidadInteractor(this,context)
    }

    override suspend fun obtenerModalidadPorId(id: Int) {
        val element= interactor.obtenerModalidadPorId(id)
        view.mostrarModalidad(element)
    }

    override suspend fun actualizar(modalidad: Modalidad) {
        interactor.actualizar(modalidad)
    }


}