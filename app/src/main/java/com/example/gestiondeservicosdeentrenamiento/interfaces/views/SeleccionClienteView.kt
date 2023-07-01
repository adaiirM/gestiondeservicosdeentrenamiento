package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface SeleccionClienteView {
    fun mostrar(list:List<DatosPersonales>)
}