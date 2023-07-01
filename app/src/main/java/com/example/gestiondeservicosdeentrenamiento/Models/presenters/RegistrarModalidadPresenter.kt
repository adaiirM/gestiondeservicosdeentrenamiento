package com.example.gestiondeservicosdeentrenamiento.Models.presenters

import android.content.Context
import com.example.gestiondeservicosdeentrenamiento.Models.interactors.RegistrarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.interactors.IRegistrarModalidadInteractor
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarModalidadPresenter

class RegistrarModalidadPresenter (context: Context):
    IRegistrarModalidadPresenter {
    private var interactor: IRegistrarModalidadInteractor

    init {
        interactor = RegistrarModalidadInteractor(this,context)
    }
    override suspend fun insertar(modalidad: Modalidad) {
        interactor.insertar(modalidad)
    }
}