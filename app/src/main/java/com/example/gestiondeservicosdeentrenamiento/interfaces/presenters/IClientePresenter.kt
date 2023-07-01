package com.example.gestiondeservicosdeentrenamiento.interfaces.presenters

import com.example.gestiondeservicosdeentrenamiento.db.entidades.*

interface IClientePresenter {
    suspend fun obtenerTodosLosDatosPersonales()
    suspend fun eliminar(datosPersonales: DatosPersonales)
    suspend fun eliminar(datosMedicos: DatosMedicos)
    suspend fun eliminar(cliente: Cliente)
    suspend fun eliminar(contacto: Contacto)
    suspend fun eliminar(ubicacion: Ubicacion)

}