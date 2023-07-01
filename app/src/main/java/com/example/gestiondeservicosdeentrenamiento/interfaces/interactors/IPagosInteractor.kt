package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface IPagosInteractor {
    suspend fun consultar(id: Int):List<Subscripcion>
    suspend fun consultarDatosPersonalesByIdCliente(id: Int): DatosPersonales
    suspend fun consultarModalidadById(id:Int): Modalidad
    suspend fun consultarServicioByIdModalidad(id: Int): Servicio
}