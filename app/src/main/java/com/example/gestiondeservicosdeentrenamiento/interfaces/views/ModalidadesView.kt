package com.example.gestiondeservicosdeentrenamiento.interfaces.views

import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

interface ModalidadesView {
    suspend fun mostarModalidades(list:  List<Modalidad>)
}