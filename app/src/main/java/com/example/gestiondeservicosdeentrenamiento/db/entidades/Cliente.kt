package com.example.gestiondeservicosdeentrenamiento.db.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cliente")
class Cliente ( @ColumnInfo(name = "id_cliente") @PrimaryKey(autoGenerate = true) val id_cliente: Int){
    constructor():this(0)
}