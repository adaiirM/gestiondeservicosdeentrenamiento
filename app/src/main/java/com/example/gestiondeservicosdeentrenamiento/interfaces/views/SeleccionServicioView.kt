package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface SeleccionServicioView {
    fun mostrarLista(list:List<Modalidad>)
    fun mostrarServicioById(servicio: Servicio)
}