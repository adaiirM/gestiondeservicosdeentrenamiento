package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "servicio")
data class Servicio(@ColumnInfo(name = "id_servicio") @PrimaryKey(autoGenerate = true) val id_servicio: Int){
    @ColumnInfo(name = "nombre") lateinit var  nombre: String
    @ColumnInfo(name = "descripcion") lateinit var descripcion: String

    constructor():this(0)
    constructor(
        nombre:String,
        descripcion:String
    ):this(0){
        this.nombre=nombre
        this.descripcion= descripcion
    }
    constructor(
        id_servicio:Int,
        nombre:String,
        descripcion:String
    ):this(id_servicio){
        this.nombre=nombre
        this.descripcion= descripcion
    }

}

