package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.EstadoPago

@Dao
interface EstadoPagoDao {
    @Insert
    fun insert(estadoPago: EstadoPago)

    @Update
    fun update(estadoPago: EstadoPago)

    @Delete
    fun delete(estadoPago: EstadoPago)

    @Query("SELECT * FROM estado_pago WHERE id_estado = :id")
    fun getEstadoPagoById(id: Int): EstadoPago

    @Query("SELECT * FROM estado_pago")
    fun getAllEstadoPagos(): List<EstadoPago>
}