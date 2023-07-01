package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estado_pago")
data class EstadoPago(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_estado") val idEstado: Int
) {
    @ColumnInfo(name = "nombre") lateinit var nombre: String
    constructor(nombre: String) : this(0){
        this.nombre=nombre
    }

    constructor(idEstado: Int, nombre: String): this(idEstado){
        this.nombre=nombre
    }
}
