package com.example.gestiondeservicosdeentrenamiento.views.servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.ServicioAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.RegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.ServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityMainBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityServiciosBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarServicioView
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ServicioView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiciosActivity : AppCompatActivity(), ServicioView, ServicioAdapter.ServicioListener {
    lateinit var binding: ActivityServiciosBinding
    private lateinit var dialogFragment : RegistrarServicioFragment
    private lateinit var presenter: IServicioPresenter
    private lateinit var listaServicio: List<Servicio>
    private lateinit var adapter: ServicioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServiciosBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        presenter= ServicioPresenter(this, this.applicationContext)

        lifecycleScope.launch(Dispatchers.IO) {
            inicializarRecycler()
        }

        binding.agregar.setOnClickListener {
            dialogFragment = RegistrarServicioFragment()
            dialogFragment.show(supportFragmentManager, "dialog")
        }
    }

    private suspend fun inicializarRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        presenter.obtenerTodosLosServicios()
        adapter= ServicioAdapter(listaServicio,this)
        binding.recycler.adapter= adapter
    }

    override suspend fun mostrarServicios(list: List<Servicio>) {
        listaServicio= list
    }

    override fun onServicioSelectedEdit(servicio: Servicio) {
        val bundle = Bundle().apply {
            putInt("id_servicio", servicio.id_servicio)
        }

        val dialogFragment = EditarServicioFragment()
        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "tag")
    }

    override fun onServicioSelectedDelete(servicio: Servicio) {
        lifecycleScope.launch(Dispatchers.IO){
            presenter.eliminar(servicio)
        }
    }

    override fun onServicioSelectedItem(servicio: Servicio) {
        val intent= Intent(this, ModalidadesActivity::class.java)
        intent.putExtra("id_servicio",servicio.id_servicio)
        startActivity(intent)
    }


}