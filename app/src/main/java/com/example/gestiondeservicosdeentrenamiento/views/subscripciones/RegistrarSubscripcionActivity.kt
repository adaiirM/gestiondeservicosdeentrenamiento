package com.example.gestiondeservicosdeentrenamiento.views.subscripciones

import android.R
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.lifecycleScope
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.RegistrarSubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityRegistrarSubscripcionBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarSubscripcionesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarSubscripcionesView
import com.example.gestiondeservicosdeentrenamiento.views.ManejoFechas
import com.example.gestiondeservicosdeentrenamiento.views.servicios.EditarServicioFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class RegistrarSubscripcionActivity : AppCompatActivity(), RegistrarSubscripcionesView, SeleccionClienteFragment.DataSet , SeleccionServicioFragment.DataSet {
    private lateinit var binding: ActivityRegistrarSubscripcionBinding
    private lateinit var presenter: IRegistrarSubscripcionesPresenter
    private lateinit var cliente: DatosPersonales
    private lateinit var modalidad: ModalidadServicio
    private lateinit var servicio: Servicio
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarSubscripcionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= RegistrarSubscripcionPresenter(this, this.applicationContext)
        llenarSpinner()
        lanzarDatePicker1()
        /*
        if(::modalidad.isInitialized){
            if((binding.cantidad!=null &&  binding.fechaIni!=null) ){
                obteneFecha()
            }else if( binding.cantidad.toString()!=" " && binding.fechaIni.toString()!=" "){
                obteneFecha()
            }
        }

         */
        binding.cantidad.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // not needed
            }

            override fun afterTextChanged(s: Editable?) {
                if (::modalidad.isInitialized && binding.cantidad.text!!.isNotEmpty() && binding.fechaIni.text!!.isNotEmpty()) {
                    obteneFecha()
                }
            }
        })

        clickNombre()
        clickServicio()
        guardar()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun guardar(){
        binding.guardar.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                presenter.registrar(optenerDatos())
            }
            var intent= Intent(this, SubscripcionesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun llenarSpinner() {
        val elementos = listOf("Selecciona una opción","Pagado","Pendiente")
        val opcionesAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, elementos)
        opcionesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.estado.adapter = opcionesAdapter
    }

    private fun clickNombre(){
        binding.cliente.setOnClickListener{
            val dialogFragment = SeleccionClienteFragment()
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }

    private fun clickServicio(){
        binding.servicio.setOnClickListener{
            val dialogFragment = SeleccionServicioFragment()
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun optenerDatos():Subscripcion{
        val opcionSeleccionada = binding.estado.selectedItemPosition
        val opcion = binding.estado.getItemAtPosition(opcionSeleccionada)
        System.out.println("La opcion es:" + opcion)
        if (::modalidad.isInitialized && binding.cantidad.text!!.isNotEmpty() && binding.fechaIni.text!!.isNotEmpty()) {
            obteneFecha()
        }
        System.out.println("La fecha de fin es: "+ binding.fechaFin.text.toString())
        return Subscripcion(
            modalidad.modalidad.precio*binding.cantidad.text.toString().toInt(),
            binding.fechaIni.text.toString(),
            binding.fechaFin.text.toString(),
            binding.cantidad.text.toString().toInt(),
            cliente.id_cliente,
            optenerId(),
            modalidad.modalidad.id_modalidad
        )
    }

    override fun onDataSetCliente(cliente: DatosPersonales) {
        this.cliente= cliente
        runOnUiThread {
            binding.cliente.setText(cliente.nombre + " " + cliente.apellido_p + " " + cliente.apellido_p)
        }
    }

    private fun optenerId(): Int{
        var id=0
        when(binding.estado.selectedItem.toString()){
            "Pagado" ->{
                id= 1
            }
            "Pendiente" ->{
                id= 2
            }
        }
        return id
    }
    override fun onDataSetServicio(modalidad: ModalidadServicio) {
        this.modalidad= modalidad
        runOnUiThread {
            binding.servicio.setText(modalidad.servicio.nombre + " " + modalidad.modalidad.nombre + " " + modalidad.modalidad.precio)
        }
    }

    private fun twoDigits(n: Int): String {
        return if (n <= 9) "0$n" else n.toString()
    }
    fun lanzarDatePicker1() {
        binding.fechaIni.setOnClickListener {
            showDatePickerDialog1()

        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun obteneFecha(){
        lateinit var fin: LocalDate
        runOnUiThread{
            if(modalidad.modalidad.nombre=="Día"){
                fin=sumarDiaFechas(binding.fechaIni.text.toString(), binding.cantidad.text.toString().toInt())
            } else if(modalidad.modalidad.nombre=="Semana"){
                fin=sumarSemanaFechas(binding.fechaIni.text.toString(), binding.cantidad.text.toString().toInt())
            } else if(modalidad.modalidad.nombre=="Semana"){
                fin=sumarMesFechas(binding.fechaIni.text.toString(), binding.cantidad.text.toString().toInt())
            }
            System.out.println("La fecha de fin es: "+fin)
            binding.fechaFin.setText(fin.toString())
        }
    }
    private fun showDatePickerDialog1() {
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val diaSeleccionado = "${twoDigits(dayOfMonth)}-${twoDigits(month + 1)}-$year"
            binding.fechaIni.setText( diaSeleccionado)
        })
        newFragment.show(supportFragmentManager, "datePicker")
    }



    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun fechaDate(string: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return LocalDate.parse(string, formatter)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarDiaFechas(fecha:String, cantidad:Int): LocalDate{
        val f= fechaDate(fecha)
        return f.plusDays(cantidad.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarSemanaFechas(fecha:String, cantidad:Int): LocalDate {
        val f= fechaDate(fecha)
        return f.plusWeeks(cantidad.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarMesFechas(fecha:String, cantidad:Int): LocalDate {
        val f= fechaDate(fecha)
        return f.plusMonths(cantidad.toLong())
    }

}