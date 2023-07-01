package com.example.gestiondeservicosdeentrenamiento.db.daos

import androidx.room.*
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto

@Dao
interface ContactoDao {
    @Insert
    fun insert(contacto: Contacto)

    @Update
    fun update(contacto: Contacto)

    @Delete
    fun delete(contacto: Contacto)

    @Query("SELECT * FROM contacto WHERE id_contacto = :id")
    fun getContactoById(id: Int): Contacto

    @Query("SELECT * FROM contacto WHERE id_cliente = :id")
    fun getContactoByIdCliente(id: Int): Contacto

    @Query("SELECT * FROM contacto")
    fun getAllContactos(): List<Contacto>
}