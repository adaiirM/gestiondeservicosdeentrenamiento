package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.*

interface IRegistrarClientePresenter {
    suspend fun insertarCliente(cliente: Cliente)
    suspend fun eliminar(cliente: Cliente)
    suspend fun insertarPersonales(datosPersonales: DatosPersonales)
    suspend fun insertarMedicos(datosMedicos: DatosMedicos)
    suspend fun insertarContacto(contacto: Contacto)
    suspend fun insertarUbicacion(ubicacion: Ubicacion)
}