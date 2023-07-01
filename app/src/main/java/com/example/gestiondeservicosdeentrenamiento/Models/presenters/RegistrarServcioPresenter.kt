package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.RegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarServicioInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarServicioView

class RegistrarServcioPresenter (view: RegistrarServicioView, context: Context):
    IRegistrarServcioPresenter {
    private var interactor: IRegistrarServicioInteractor
    private var view:RegistrarServicioView

    init {
        this.view = view
        //Pasamos al interactor un instancia del presentador y el contexto de la aplicación
        interactor = RegistrarServicioInteractor(this,context)
    }

    override suspend fun insertar(servicio: Servicio) {
        interactor.insertar(servicio)
    }
}