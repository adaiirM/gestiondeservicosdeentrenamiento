package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface ISubscripcionInteractor {
    suspend fun consultar():List<Subscripcion>
    suspend fun consultarDatosPersonalesByIdCliente(id: Int): DatosPersonales
    suspend fun consultarModalidadById(id:Int): Modalidad
    suspend fun consultarServicioByIdModalidad(id: Int): Servicio

    suspend fun cambiar(subscripcion: Subscripcion)
    suspend fun cancelar(subscripcion: Subscripcion)
}