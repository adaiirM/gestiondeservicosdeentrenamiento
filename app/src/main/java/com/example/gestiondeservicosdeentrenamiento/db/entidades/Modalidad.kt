package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modalidad")
data class Modalidad(@ColumnInfo(name = "id_modalidad") @PrimaryKey(autoGenerate = true) val id_modalidad: Int){
    @ColumnInfo(name = "nombre") lateinit var nombre: String
    @ColumnInfo(name = "precio")  var precio: Double=0.0
    @ColumnInfo(name = "id_servicio") var id_servicio: Int=0

    constructor():this(0)

    constructor(
        nombre: String,
        precio: Double,
        id_servicio: Int
    ):this(0){
        this.nombre=nombre
        this.precio= precio
        this.id_servicio= id_servicio
    }

    constructor(
        id_modalidad: Int,
        nombre: String,
        precio: Double,
        id_servicio: Int
    ):this(id_modalidad){
        this.nombre=nombre
        this.precio= precio
        this.id_servicio= id_servicio
    }
}
