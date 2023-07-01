package com.example.gestiondeservicosdeentrenamiento.views.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.VerClientePresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityClientesBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityVerClienteBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IVerClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.VerClienteView
import com.example.gestiondeservicosdeentrenamiento.views.servicios.EditarServicioFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VerClienteActivity : AppCompatActivity(), VerClienteView {
    private lateinit var binding: ActivityVerClienteBinding
    private lateinit var presenter: IVerClientePresenter
    private lateinit var contactoSelect: Contacto
    private lateinit var datosPesonalesSelect: DatosPersonales
    private var id_cliente: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerClienteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= VerClientePresenter(this, this.applicationContext)

        val bundle = intent.extras
        id_cliente = bundle?.getInt("id_cliente")!!

        lifecycleScope.launch(Dispatchers.IO){
            presenter.consultarContacto(id_cliente)
            presenter.consultarDatosPErsonales(id_cliente)
        }
        editContacto()
        editUbicacion()
        editDatosPersonales()
        editMedicos()

    }

    private fun editContacto(){
        binding.contacto.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("id_cliente", id_cliente)
            }

            val dialogFragment = DatosContatoFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }
    private fun editUbicacion(){
        binding.ubicacion.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("id_cliente", id_cliente)
            }

            val dialogFragment = DatosUbicacionFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }
    private fun editDatosPersonales(){
        binding.personales.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("id_cliente", id_cliente)
            }

            val dialogFragment = DatosPersonalesFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }

    private fun editMedicos(){
        binding.medicos.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("id_cliente", id_cliente)
            }

            val dialogFragment = DatosMedicosFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }

    private fun llenarCamposContacto(){
        runOnUiThread {
            binding.Email.text = contactoSelect.correo
            binding.Telefono.text = contactoSelect.telefono
        }
    }
    private fun llenarCamposDatos(){
        runOnUiThread {
            binding.nombre.text= datosPesonalesSelect.nombre+" "+ datosPesonalesSelect.apellido_m
        }
    }

    override fun mostrarContacto(contacto: Contacto) {
        contactoSelect=contacto
        llenarCamposContacto()
    }

    override fun mostrarDatosPersonales(datosPersonales: DatosPersonales) {
        datosPesonalesSelect=datosPersonales
        llenarCamposDatos()
    }
}