package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

interface PagosView {
    fun mostra(subscripcion: List<Subscripcion>)
    fun mostrarDatosPersonales(datosPersonales: DatosPersonales)
    fun mostrarModalidad(modalidad: Modalidad)
    fun mostrarServicio(servicio: Servicio)
}