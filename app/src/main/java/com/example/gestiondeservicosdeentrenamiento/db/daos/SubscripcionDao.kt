package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

@Dao
interface SubscripcionDao {
    @Insert
    fun insert(subscripcion: Subscripcion)

    @Update
    fun update(subscripcion: Subscripcion)

    @Delete
    fun delete(subscripcion: Subscripcion)

    @Query("SELECT * FROM subscripcion WHERE id_suscripcion = :id")
    fun getSubscripcionById(id: Int): Subscripcion

    @Query("SELECT * FROM subscripcion WHERE id_estado_pago = :id")
    fun getSubscripcionByIdEstdao(id: Int):List< Subscripcion>

    @Query("SELECT * FROM subscripcion")
    fun getAllSubscripciones(): List<Subscripcion>



}