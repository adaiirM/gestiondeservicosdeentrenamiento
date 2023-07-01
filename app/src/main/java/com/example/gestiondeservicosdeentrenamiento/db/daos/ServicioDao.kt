package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

@Dao
interface ServicioDao {
    @Insert
    fun insert(servicio: Servicio)

    @Update
    fun update(servicio: Servicio)

    @Delete
    fun delete(servicio: Servicio)

    @Query("SELECT * FROM servicio WHERE id_servicio = :id")
    fun getServicioById(id: Int): Servicio

    @Query("SELECT * FROM servicio")
    fun getAllServicios(): List<Servicio>
}