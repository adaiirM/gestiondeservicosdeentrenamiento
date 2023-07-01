package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.*

interface IRegistrarClienteInteractor {
    suspend fun insertarCliente(cliente: Cliente):Long
    suspend   fun eliminar(cliente: Cliente)
    suspend fun insertarPersonales(datosPersonales: DatosPersonales)
    suspend fun insertarMedicos(datosMedicos: DatosMedicos)
    suspend fun insertarContacto(contacto: Contacto)
    suspend fun insertarUbicacion(ubicacion: Ubicacion)
}