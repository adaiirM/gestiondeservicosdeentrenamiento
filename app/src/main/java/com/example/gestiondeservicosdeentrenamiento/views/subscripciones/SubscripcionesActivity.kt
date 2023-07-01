package com.example.gestiondeservicosdeentrenamiento.views.subscripciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.SubscripcionAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.SubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivitySubscripcionesBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SubscripcionView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubscripcionesActivity : AppCompatActivity(), SubscripcionView, SubscripcionAdapter.SubsListener {

    private lateinit var binding: ActivitySubscripcionesBinding
    private lateinit var presenter: ISubscripcionPresenter
    private lateinit var adapter: SubscripcionAdapter
    private  var lista=mutableListOf<ClienteSubscripcion>()
    private lateinit var listaSub: List<Subscripcion>
    private lateinit var datos: DatosPersonales
    private lateinit var servicio:Servicio
    private lateinit var modalidad: Modalidad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscripcionesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= SubscripcionPresenter(this, this.applicationContext)

        lifecycleScope.launch(Dispatchers.IO){
            inicializarRecycler()
        }
        agregar()

    }

    override fun onBackPressed() {
        finish()
    }
    private fun agregar(){
        binding.agregarservicio.setOnClickListener {
            var intent= Intent(this, RegistrarSubscripcionActivity::class.java )
            startActivity(intent)
        }
    }

    private suspend fun inicializarRecycler(){
        presenter.consultar()
       // runOnUiThread {
            binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = SubscripcionAdapter(lista, this)
            binding.recycler.adapter = adapter
       // }
    }

    private fun crearLista(){
        lifecycleScope.launch(Dispatchers.IO){
            withContext(Dispatchers.IO) {
                for(list in listaSub){
                    presenter.consultarDatosPersonalesByIdCliente(list.idCliente)
                    presenter.consultarModalidadById(list.idModalidad)
                    withContext(Dispatchers.IO){
                        presenter.consultarServicioByIdModalidad(modalidad.id_servicio)
                    }
                    var cliente=ClienteSubscripcion(datos,list, modalidad, servicio)
                    lista.add(cliente)
                }
            }
        }

    }

    override fun mostra(subscripcion: List<Subscripcion>) {
        listaSub= subscripcion
        crearLista()
    }

    override fun mostrarDatosPersonales(datosPersonales: DatosPersonales) {
        datos= datosPersonales
    }

    override fun mostrarModalidad(modalidad: Modalidad) {
        this.modalidad= modalidad
    }

    override fun mostrarServicio(servicio: Servicio) {
        this.servicio=servicio
    }





    override fun onPagarClicked(subscription: ClienteSubscripcion) {

        lifecycleScope.launch(Dispatchers.IO){
            subscription.subscripcion.idEstadoPago=1
            System.out.println("Pagado el dis es :"+ subscription.subscripcion.idEstadoPago)
            presenter.cambiar(subscription.subscripcion)
        }
    }

    override fun onCancelarClicked(subscription: ClienteSubscripcion) {
        lifecycleScope.launch(Dispatchers.IO){
            subscription.subscripcion.idEstadoPago=2
            System.out.println("Pagado el dis es :"+ subscription.subscripcion.idEstadoPago)
            presenter.cancelar(subscription.subscripcion)
        }
    }
}