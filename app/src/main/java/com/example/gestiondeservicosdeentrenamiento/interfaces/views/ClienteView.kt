package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface ClienteView {
    fun mostrarClientes(list: List<DatosPersonales>)
}