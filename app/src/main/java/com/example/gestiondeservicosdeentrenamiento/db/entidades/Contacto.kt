package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacto" )
data class Contacto(
    @ColumnInfo(name = "id_contacto") @PrimaryKey(autoGenerate = true) val idContacto: Int
){
    @ColumnInfo(name = "id_cliente") var id_cliente: Int=0
    @ColumnInfo(name = "telefono") lateinit var telefono: String
    @ColumnInfo(name = "correo") lateinit var correo: String

    constructor():this(0)

    constructor(
        telefono:String,
        correo:String,
        idCliente: Int
    ):this(0){
        this.telefono=telefono
        this.correo=correo
        this.id_cliente= idCliente
    }

    constructor(
        idContacto: Int,
        telefono:String,
        correo:String,
        idCliente: Int
    ):this(idContacto){
        this.telefono=telefono
        this.correo=correo
        this.id_cliente= idCliente
    }

}
