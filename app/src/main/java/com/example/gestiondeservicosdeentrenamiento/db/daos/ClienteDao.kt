package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Cliente

@Dao
interface ClienteDao {
    @Insert
    fun insert(cliente: Cliente): Long

    @Update
    fun update(cliente: Cliente)

    @Delete
    fun delete(cliente: Cliente)

    @Query("SELECT * FROM cliente WHERE id_cliente = :id")
    fun getClienteById(id: Int): Cliente

    @Query("SELECT * FROM cliente")
    fun getAllClientes(): List<Cliente>
}