package com.example.gestiondeservicosdeentrenamiento.db.AppDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.db.daos.*

@Database(entities = [Cliente::class, Servicio::class, EstadoPago::class, Subscripcion::class, Modalidad::class, DatosPersonales::class, DatosMedicos::class, Contacto::class, Ubicacion::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun servicioDao(): ServicioDao
    abstract fun estadoDao(): EstadoPagoDao
    abstract fun subscripcionDao(): SubscripcionDao
    abstract fun modalidadDao(): ModalidadDao
    abstract fun datosPersonalesDao(): DatosPersonalesDao
    abstract fun datosMedicosDao(): DatosMedicosDao
    abstract fun contactoDao(): ContactoDao
    abstract fun ubicacionDao(): UbicacionDao
}