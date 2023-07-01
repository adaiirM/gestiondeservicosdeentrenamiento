package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.*

interface IClienteInteractor {
    suspend fun obtenerTodosLosDatosPersonales(): List<DatosPersonales>
    suspend fun eliminar(datosPersonales: DatosPersonales)
    suspend fun eliminar(datosMedicos: DatosMedicos)
    suspend fun eliminar(cliente: Cliente)
    suspend fun eliminar(contacto: Contacto)
    suspend fun eliminar(ubicacion: Ubicacion)

}