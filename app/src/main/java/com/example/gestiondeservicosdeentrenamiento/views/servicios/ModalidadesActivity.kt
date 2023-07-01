package com.example.gestiondeservicosdeentrenamiento.views.servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.ModalidadAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.ModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityModalidadesBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IModalidadesPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.ModalidadesView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ModalidadesActivity : AppCompatActivity(),ModalidadAdapter.ModalidadListener, ModalidadesView,RegistrarModalidadFragment.DataSet{
    lateinit var binding: ActivityModalidadesBinding
    private lateinit var presenter: IModalidadesPresenter
    private lateinit var adapter: ModalidadAdapter
    private lateinit var listaModalidades: List<Modalidad>
    private var insercion: Boolean= false
    private  var id: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityModalidadesBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        presenter= ModalidadesPresenter(this, this.applicationContext)

        val bundle= intent.extras
        id= bundle?.getInt("id_servicio")!!
        System.out.println("El id es: "+ id)

        lifecycleScope.launch(Dispatchers.IO) {
            inicializarRecycler()
        }
        if(insercion){
            System.out.println("Despues de la insersión el estado es: "+ insercion)
            System.out.println("El tamaño de la lista era!!: "+ adapter.itemCount)
            val num=adapter.itemCount + 1
            adapter.notifyItemInserted(num )
            System.out.println("El tamaño de la lista es: "+ adapter.itemCount)
        }

        agregar()

    }

    private suspend fun inicializarRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        presenter.obtenerModalidadesPorIdServicio(id)
        adapter= ModalidadAdapter(listaModalidades,this)
        binding.recycler.adapter= adapter
    }

    private fun agregar(){
        val bundle = Bundle().apply {
            putInt("id_servicio", id)
        }

        binding.agregar.setOnClickListener {
            val dialogFragment = RegistrarModalidadFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(supportFragmentManager, "tag")
        }
    }

    override fun onEditClicked(modalidad: Modalidad) {
        val bundle = Bundle().apply {
            putInt("id_modalidad", modalidad.id_modalidad)
        }

        val dialogFragment = EditarModalidadFragment()
        dialogFragment.arguments = bundle
        dialogFragment.show(supportFragmentManager, "tag")

    }

    override fun onDeleteClicked(modalidad: Modalidad) {
        lifecycleScope.launch(Dispatchers.IO){
            presenter.eliminar(modalidad)
        }
    }

    override suspend fun mostarModalidades(list: List<Modalidad>) {
        listaModalidades= list
        val num= listaModalidades.size -1
        System.out.println("El tamaño de la lista es: "+ num)
    }

    override fun onDataSet(estado: Boolean) {
        insercion= estado
        System.out.println("Despues de la insersión el estado es: "+ insercion)
        if(insercion){
            System.out.println("El tamaño de la lista era!!: "+ adapter.itemCount)
            val num=adapter.itemCount + 1
            adapter.notifyItemInserted(num )
            System.out.println("El tamaño de la lista es: "+ adapter.itemCount)
            lifecycleScope.launch(Dispatchers.IO){
                inicializarRecycler()
            }
        }
    }
}