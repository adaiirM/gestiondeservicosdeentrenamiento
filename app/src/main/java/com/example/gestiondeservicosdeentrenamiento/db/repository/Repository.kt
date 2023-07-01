package com.example.gestiondeservicosdeentrenamiento.db.repository

import android.content.Context
import androidx.room.Room
import com.example.gestiondeservicosdeentrenamiento.db.AppDb.AppDb
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*


private const val DATABASE_NAME = "servicios_entrenamiento.db"
class Repository private constructor(context: Context){
    private val dbRoom: AppDb = Room.databaseBuilder(
        context.applicationContext,
        AppDb:: class.java,
        DATABASE_NAME
    ).build()
    private val clienteDao = dbRoom.clienteDao()
    private val contactoDao =  dbRoom.contactoDao()
    private val medicosDao = dbRoom.datosMedicosDao()
    private val personalesDao = dbRoom.datosPersonalesDao()
    private val ubicacionDao= dbRoom.ubicacionDao()
    private val servicioDao = dbRoom.servicioDao()
    private val modalidadDao = dbRoom.modalidadDao()
    private val estadoDao= dbRoom.estadoDao()
    private val subscripcionDao= dbRoom.subscripcionDao()



    //Operaciones cliente
     fun insertarCliente(cliente: Cliente):Long = clienteDao.insert(cliente)
     fun actualizarCliente(cliente: Cliente) = clienteDao.update(cliente)
     fun eliminarCliente(cliente: Cliente) = clienteDao.delete(cliente)
     fun consultarClientePorId(id: Int): Cliente = clienteDao.getClienteById(id=id)
     fun consultarTodosLosClientes(): List<Cliente> = clienteDao.getAllClientes()

    //Operaciones Contacto
    suspend fun insertContacto(contacto: Contacto) = contactoDao.insert(contacto)
    suspend fun updateContacto(contacto: Contacto) = contactoDao.update(contacto)
    suspend fun deleteContacto(contacto: Contacto) = contactoDao.delete(contacto)
    suspend fun getContactoById(id: Int): Contacto = contactoDao.getContactoById(id=id)
    suspend fun getAllContactos(): List<Contacto> = contactoDao.getAllContactos()
    suspend fun getContactoByIdCliente(id: Int): Contacto = contactoDao.getContactoByIdCliente(id = id)

    //Operaciones DatosMedicos
    suspend fun insertDatosMedicos(datosMedicos: DatosMedicos) = medicosDao.insert(datosMedicos)
    suspend fun updateDatosMedicos(datosMedicos: DatosMedicos) = medicosDao.update(datosMedicos)
    suspend fun deleteDatosMedicos(datosMedicos: DatosMedicos) = medicosDao.delete(datosMedicos)
    suspend fun getDatosMedicosById(id: Int): DatosMedicos = medicosDao.getDatosMedicosById(id=id)
    suspend fun getAllDatosMedicos(): List<DatosMedicos> = medicosDao.getAllDatosMedicos()
    suspend fun getDatosMedicosByIdClinete(id: Int): DatosMedicos = medicosDao.getDatosMedicosById(id=id)


    //Operaciones datos personales
    suspend fun insertarPersonales(datosPersonales: DatosPersonales) = personalesDao.insert(datosPersonales)
    suspend fun actualizarPersonales(datosPersonales: DatosPersonales) = personalesDao.update(datosPersonales)
    suspend fun eliminarPerosanles(datosPersonales: DatosPersonales) = personalesDao.delete(datosPersonales)
    suspend fun obtenerDatosPersonalesPorId(id: Int): DatosPersonales = personalesDao.getDatosPersonalesById(id=id)
    suspend fun obtenerTodosLosDatosPersonales(): List<DatosPersonales> = personalesDao.getAllDatosPersonales()
    //suspend fun obtenerDatosPersonalesByIdServicio(id: Int): List<DatosPersonales> = personalesDao.obtenerDatosPersonalesPorIdServicio(idServicio = id)
    fun obtenerDatosPByIdCliente(id: Int): DatosPersonales= personalesDao.obtenerDatosPersonalesPorIdCliente(idCliente =  id)

    //Operaciones Estado pago
    suspend fun insertarEstado(estadoPago: EstadoPago) = estadoDao.insert(estadoPago)
    suspend fun actualizarEstado(estadoPago: EstadoPago) = estadoDao.update(estadoPago)
    suspend fun eliminarEstado(estadoPago: EstadoPago) = estadoDao.delete(estadoPago)
    suspend fun obtenerEstadoPagoPorId(id: Int): EstadoPago = estadoDao.getEstadoPagoById(id=id)
    suspend fun obtenerTodosLosEstadoPagos(): List<EstadoPago> = estadoDao.getAllEstadoPagos()

    //Operaciones Modalidad
    suspend fun insertarModalidad(modalidad: Modalidad) = modalidadDao.insert(modalidad)
    suspend fun actualizarModalidad(modalidad: Modalidad) = modalidadDao.update(modalidad)
    suspend fun eliminarModalidad(modalidad: Modalidad) = modalidadDao.delete(modalidad)
    suspend fun obtenerModalidadPorId(id: Int): Modalidad = modalidadDao.getModalidadById(id=id)
    suspend fun obtenerModalidadPorIdServicio(id: Int): List<Modalidad> = modalidadDao.getModalidadByIdServicio(id=id)
    suspend fun obtenerTodasLasModalidades(): List<Modalidad> = modalidadDao.getAllModalidades()

    //Operaciones Servicio
    suspend fun insertarServicio(servicio: Servicio) = servicioDao.insert(servicio)
    suspend fun actualizarServicio(servicio: Servicio) = servicioDao.update(servicio)
    suspend fun eliminarServicio(servicio: Servicio) = servicioDao.delete(servicio)
    suspend fun obtenerServicioPorId(id: Int): Servicio = servicioDao.getServicioById(id=id)
    suspend fun obtenerTodosLosServicios(): List<Servicio> = servicioDao.getAllServicios()

    //Operaciones Subscripcion
    suspend fun insertarSubscripcion(subscripcion: Subscripcion) = subscripcionDao.insert(subscripcion)
    suspend fun actualizarSubscripcion(subscripcion: Subscripcion) = subscripcionDao.update(subscripcion)
    suspend fun eliminarSubscripcion(subscripcion: Subscripcion) = subscripcionDao.delete(subscripcion)
    suspend fun obtenerSubscripcionPorId(id: Int): Subscripcion = subscripcionDao.getSubscripcionById(id= id)
    suspend fun obtenerTodasLasSubscripciones(): List<Subscripcion> = subscripcionDao.getAllSubscripciones()
    fun obtenerTodasLasSubscripcionesByIdEstado(id: Int):List<Subscripcion> = subscripcionDao.getSubscripcionByIdEstdao(id= id)

    //Ubicacion
    suspend fun insertarUbicacion(ubicacion: Ubicacion) = ubicacionDao.insert(ubicacion)
    suspend fun actualizarUbicacion(ubicacion: Ubicacion) = ubicacionDao.update(ubicacion)
    suspend fun eliminarUbicacion(ubicacion: Ubicacion) = ubicacionDao.delete(ubicacion)
    suspend fun obtenerUbicacionPorId(id: Int): Ubicacion = ubicacionDao.getUbicacionById(id=id)
    suspend fun obtenerTodasLasUbicaciones(): List<Ubicacion> = ubicacionDao.getAllUbicaciones()
    fun obtenerUbicacionByIdCliente(id: Int): Ubicacion= ubicacionDao.getUbicacionByIdCliente(id= id)


    companion object{
        private var INSTANCE: Repository? = null

        fun inicializar(context: Context){
            if(INSTANCE == null){
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository{
            return INSTANCE ?: throw IllegalStateException("UserRepository debe ser inicializado")
        }
    }
}