package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.RegistrarSubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.SubscripcionIntercator
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistraSubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.ISubscripcionInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarSubscripcionesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarSubscripcionesView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SubscripcionView

class RegistrarSubscripcionPresenter (view: RegistrarSubscripcionesView, context: Context):
    IRegistrarSubscripcionesPresenter {
    private var interactor: IRegistraSubscripcionInteractor
    private var view: RegistrarSubscripcionesView

    init {
        this.view = view
        interactor = RegistrarSubscripcionInteractor(this,context)
    }

    override suspend fun registrar(subscripcion: Subscripcion) {
        interactor.registrar(subscripcion)
    }
}