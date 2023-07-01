package com.example.gestiondeservicosdeentrenamiento.interfaces.interactors

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface ISeleccionServicioInterator {
    suspend fun consultarModalidad(): List<Modalidad>
    suspend fun consultarServicioById(id: Int): Servicio
}