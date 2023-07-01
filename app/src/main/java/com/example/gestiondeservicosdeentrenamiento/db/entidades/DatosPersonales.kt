package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datos_personales")
data class DatosPersonales(@ColumnInfo(name = "id_personal") @PrimaryKey(autoGenerate = true) val id_personal: Int) {
    @ColumnInfo(name = "nombre") lateinit var  nombre: String
    @ColumnInfo(name = "apellido_p") lateinit var apellido_p: String
    @ColumnInfo(name = "apellido_m") lateinit var apellido_m: String
    @ColumnInfo(name = "id_cliente") var id_cliente: Int=0
    constructor() : this(0)
    constructor(nombre: String, apellidoP: String, apellidoM: String, idCliente: Int) : this(0){
        this.nombre = nombre
        this.apellido_m = apellidoM
        this.apellido_p= apellidoP
        this.id_cliente= idCliente
    }
    constructor(idPersonal:Int,nombre: String, apellidoP: String, apellidoM: String, idCliente: Int) : this(idPersonal){
        this.nombre = nombre
        this.apellido_m = apellidoM
        this.apellido_p= apellidoP
        this.id_cliente= idCliente
    }


}
