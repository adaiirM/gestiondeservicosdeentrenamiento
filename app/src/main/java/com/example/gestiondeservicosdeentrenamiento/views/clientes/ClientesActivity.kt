package com.example.gestiondeservicosdeentrenamiento.views.clientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.DatosPersonalesAdapter
import com.example.gestiondeservicosdeentrenamiento.Adapters.ServicioAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.ClientePresenter
import com.example.gestiondeservicosdeentrenamiento.R
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityClientesBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityRegistrarClienteBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ClienteView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientesActivity : AppCompatActivity(), ClienteView,DatosPersonalesAdapter.DatosListener {
    private lateinit var binding: ActivityClientesBinding
    private lateinit var presenter: IClientePresenter
    private lateinit var adapter: DatosPersonalesAdapter
    private lateinit var lista: List<DatosPersonales>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= ClientePresenter(this, this.applicationContext)

        lifecycleScope.launch(Dispatchers.IO){
            inicializarRecycler()
        }

        binding.agregar.setOnClickListener {
            var intent= Intent(this, RegistrarClienteActivity::class.java)
            startActivity(intent)
        }
    }

    private suspend fun inicializarRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        presenter.obtenerTodosLosDatosPersonales()
        adapter= DatosPersonalesAdapter(lista,this)
        binding.recycler.adapter= adapter
    }

    override fun mostrarClientes(list: List<DatosPersonales>) {
        lista= list
    }

    override fun onEditClicked(datos: DatosPersonales) {
        val intent= Intent(this, VerClienteActivity::class.java)
        intent.putExtra("id_cliente",datos.id_cliente)
        startActivity(intent)
    }

    override fun onDeleteClicked(datos: DatosPersonales) {

    }
}