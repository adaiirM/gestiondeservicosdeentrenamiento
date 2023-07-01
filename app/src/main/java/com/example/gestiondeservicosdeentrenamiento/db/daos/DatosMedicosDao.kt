package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos

@Dao
interface DatosMedicosDao {
    @Insert
    fun insert(datosMedicos: DatosMedicos)

    @Update
    fun update(datosMedicos: DatosMedicos)

    @Delete
    fun delete(datosMedicos: DatosMedicos)

    @Query("SELECT * FROM datos_medicos WHERE id_medicos = :id")
    fun getDatosMedicosById(id: Int): DatosMedicos

    @Query("SELECT * FROM datos_medicos WHERE id_cliente = :id")
    fun getDatosMByIdCliente(id:Int): DatosMedicos

    @Query("SELECT * FROM datos_medicos")
    fun getAllDatosMedicos(): List<DatosMedicos>
}