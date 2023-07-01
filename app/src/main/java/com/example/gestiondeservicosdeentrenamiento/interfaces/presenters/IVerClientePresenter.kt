package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface IVerClientePresenter {
    suspend fun consultarDatosPErsonales(id:Int)
    suspend fun consultarContacto(id: Int)
}