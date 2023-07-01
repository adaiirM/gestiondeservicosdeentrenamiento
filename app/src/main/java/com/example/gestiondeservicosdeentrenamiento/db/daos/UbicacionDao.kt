package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion

@Dao
interface UbicacionDao {
    @Insert
    fun insert(ubicacion: Ubicacion)

    @Update
    fun update(ubicacion: Ubicacion)

    @Delete
    fun delete(ubicacion: Ubicacion)

    @Query("SELECT * FROM ubicacion WHERE id_ubicacion = :id")
    fun getUbicacionById(id: Int): Ubicacion

    @Query("SELECT * FROM ubicacion WHERE id_cliente = :id")
    fun getUbicacionByIdCliente(id: Int): Ubicacion

    @Query("SELECT * FROM ubicacion")
    fun getAllUbicaciones(): List<Ubicacion>
}