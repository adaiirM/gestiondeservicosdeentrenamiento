package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

interface VerClienteView {
    fun mostrarContacto(contacto: Contacto)
    fun mostrarDatosPersonales( datosPersonales: DatosPersonales)
}