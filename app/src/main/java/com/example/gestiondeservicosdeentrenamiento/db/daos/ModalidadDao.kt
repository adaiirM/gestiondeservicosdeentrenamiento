package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

@Dao
interface ModalidadDao {
    @Insert
    fun insert(modalidad: Modalidad)

    @Update
    fun update(modalidad: Modalidad)

    @Delete
    fun delete(modalidad: Modalidad)

    @Query("SELECT * FROM modalidad WHERE id_modalidad = :id")
    fun getModalidadById(id: Int): Modalidad

    @Query("SELECT * FROM modalidad WHERE id_servicio = :id")
    fun getModalidadByIdServicio(id: Int): List<Modalidad>

    @Query("SELECT * FROM modalidad")
    fun getAllModalidades(): List<Modalidad>
}