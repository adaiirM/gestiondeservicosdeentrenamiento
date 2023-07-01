package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datos_medicos")
data class DatosMedicos(
    @ColumnInfo(name = "id_medicos") @PrimaryKey(autoGenerate = true) val id_medicos: Int
) {
    @ColumnInfo(name = "edad") var edad: Int=0
    @ColumnInfo(name = "peso") var peso: Double=0.0
    @ColumnInfo(name = "estatura") var estatura: Double=0.0
    @ColumnInfo(name = "padecimiento") lateinit var padecimiento: String
    @ColumnInfo(name = "consumo_medicamento") lateinit var consumo_medicamento: String
    @ColumnInfo(name = "presion_arterial") lateinit var presion_arterial: String
    @ColumnInfo(name = "id_cliente") var id_cliente: Int=0

    constructor() : this(0)

    constructor(
        edad: Int,
        peso: Double,
        estatura: Double,
        padecimiento: String,
        consumoMedicamento:String,
        presionArterial: String,
        idCliente: Int
    ) : this(0){
        this.edad = edad
        this.peso = peso
        this.estatura = estatura
        this.padecimiento = padecimiento
        this.consumo_medicamento = consumoMedicamento
        this.presion_arterial = presionArterial
        this.id_cliente = idCliente
    }
    constructor(
        id_medicos: Int,
        edad: Int,
        peso: Double,
        estatura: Double,
        padecimiento: String,
        consumoMedicamento:String,
        presionArterial: String,
        idCliente: Int
    ) : this(id_medicos){
        this.edad = edad
        this.peso = peso
        this.estatura = estatura
        this.padecimiento = padecimiento
        this.consumo_medicamento = consumoMedicamento
        this.presion_arterial = presionArterial
        this.id_cliente = idCliente
    }
}
