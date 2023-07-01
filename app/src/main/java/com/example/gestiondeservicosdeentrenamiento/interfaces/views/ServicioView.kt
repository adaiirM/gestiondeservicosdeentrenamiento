package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

interface ServicioView {
    suspend fun mostrarServicios(list:  List<Servicio>)
}