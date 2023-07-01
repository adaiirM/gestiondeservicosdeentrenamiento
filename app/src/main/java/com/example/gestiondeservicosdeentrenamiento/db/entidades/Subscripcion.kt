package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscripcion")
data class Subscripcion(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_suscripcion") val idSuscripcion: Int){
    @ColumnInfo(name = "monto_pago") var montoPago: Double=0.0
    @ColumnInfo(name = "fecha_inicio") lateinit var fechaInicio: String
    @ColumnInfo(name = "fecha_corte") lateinit var fechaCorte: String
    @ColumnInfo(name = "cantidad_modalidad")  var cantidad: Int=0
    @ColumnInfo(name = "id_cliente") var idCliente: Int=0
    @ColumnInfo(name = "id_estado_pago") var idEstadoPago: Int=0
    @ColumnInfo(name = "id_modalidad") var idModalidad: Int=0

    constructor():this(0)
    constructor(
        montoPago: Double,
        fechaInicio: String,
        fechaCorte: String,
        cantidad:Int,
        idCliente: Int,
        idEstadoPago: Int,
        idModalidad: Int
    ) : this(0)
    {
        this.montoPago=montoPago
        this.fechaInicio= fechaInicio
        this.fechaCorte= fechaCorte
        this.cantidad= cantidad
        this.idCliente=idCliente
        this.idEstadoPago= idEstadoPago
        this.idModalidad= idModalidad
    }

    constructor(
        idSubscripcion:Int,
        montoPago: Double,
        fechaInicio: String,
        fechaCorte: String,
        cantidad:Int,
        idCliente: Int,
        idEstadoPago: Int,
        idModalidad: Int
    ) : this(idSubscripcion)
    {
        this.montoPago=montoPago
        this.fechaInicio= fechaInicio
        this.fechaCorte= fechaCorte
        this.cantidad= cantidad
        this.idCliente=idCliente
        this.idEstadoPago= idEstadoPago
        this.idModalidad= idModalidad
    }

}

