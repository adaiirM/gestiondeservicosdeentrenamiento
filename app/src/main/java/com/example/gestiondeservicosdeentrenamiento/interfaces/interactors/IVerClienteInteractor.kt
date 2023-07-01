package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface IVerClienteInteractor {
    suspend fun consultarDatosPErsonales(id:Int): DatosPersonales
    suspend fun consultarContacto(id: Int): Contacto
}