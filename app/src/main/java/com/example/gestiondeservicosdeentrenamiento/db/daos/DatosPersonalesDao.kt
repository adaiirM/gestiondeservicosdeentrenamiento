package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

@Dao
interface DatosPersonalesDao {
    @Insert
    fun insert(datosPersonales: DatosPersonales)

    @Update
    fun update(datosPersonales: DatosPersonales)

    @Delete
    fun delete(datosPersonales: DatosPersonales)

    @Query("SELECT * FROM datos_personales WHERE id_personal = :id")
    fun getDatosPersonalesById(id: Int): DatosPersonales

    /*
    @Query("SELECT * FROM datos_personales WHERE id_servicio = :idServicio")
    fun obtenerDatosPersonalesPorIdServicio(idServicio: Int): List<DatosPersonales>

     */

    @Query("SELECT * FROM datos_personales WHERE id_cliente = :idCliente")
    fun obtenerDatosPersonalesPorIdCliente(idCliente: Int):DatosPersonales

    @Query("SELECT * FROM datos_personales")
    fun getAllDatosPersonales(): List<DatosPersonales>
}