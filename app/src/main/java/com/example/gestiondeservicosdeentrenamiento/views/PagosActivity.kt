package com.example.gestiondeservicosdeentrenamiento.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.PagosAdapter
import com.example.gestiondeservicosdeentrenamiento.Adapters.SubscripcionAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.PagosPresenter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.SubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityPagosBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivitySubscripcionesBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.*
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IPagosPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISubscripcionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.PagosView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SubscripcionView
import com.example.gestiondeservicosdeentrenamiento.views.subscripciones.RegistrarSubscripcionActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PagosActivity : AppCompatActivity(), PagosView,PagosAdapter.SubsListener {

    private lateinit var binding: ActivityPagosBinding
    private lateinit var presenter: IPagosPresenter
    private lateinit var adapter: PagosAdapter
    private  var lista=mutableListOf<ClienteSubscripcion>()
    private lateinit var listaSub: List<Subscripcion>
    private lateinit var datos: DatosPersonales
    private lateinit var servicio: Servicio
    private lateinit var modalidad: Modalidad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= PagosPresenter(this, this.applicationContext)

        lifecycleScope.launch(Dispatchers.IO){
            inicializarRecycler()
        }
    }

    override fun onBackPressed() {
        finish()
    }


    private suspend fun inicializarRecycler(){
        presenter.consultar(2)
        // runOnUiThread {
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = PagosAdapter(lista, this)
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
                    var cliente= ClienteSubscripcion(datos,list, modalidad, servicio)
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

}