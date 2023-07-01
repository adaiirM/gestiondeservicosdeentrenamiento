package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ubicacion")
data class Ubicacion(@ColumnInfo(name = "id_ubicacion") @PrimaryKey(autoGenerate = true) val idUbicacion: Int
) {
    @ColumnInfo(name = "estado") var estado: String = ""
    @ColumnInfo(name = "colonia") var colonia: String = ""
    @ColumnInfo(name = "cp") var cp: String = ""
    @ColumnInfo(name = "id_cliente") var id_cliente: Int = 0

    constructor():this(0)
    constructor(
        estado: String,
        colonia: String,
        cp: String,
        idCliente: Int
    ) : this(0){
        this.estado= estado
        this.colonia= colonia
        this.cp= cp
        this.id_cliente= idCliente
    }
    constructor(
        idUbicacion: Int,
        estado: String,
        colonia: String,
        cp: String,
        idCliente: Int
    ) : this(idUbicacion){
        this.estado= estado
        this.colonia= colonia
        this.cp= cp
        this.id_cliente= idCliente
    }
}
