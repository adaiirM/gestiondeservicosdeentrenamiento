package com.example.gestiondeservicosdeentrenamiento.views.subscripciones

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestiondeservicosdeentrenamiento.Adapters.ClienteAdapter
import com.example.gestiondeservicosdeentrenamiento.Adapters.ModalidadServicioAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.SeleccionServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentSeleccionServicioBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.ModalidadServicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SeleccionServicioView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SeleccionServicioFragment : DialogFragment(), SeleccionServicioView, ModalidadServicioAdapter.itemOnClick {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentSeleccionServicioBinding
    private lateinit var presenter: ISeleccionServicioPresenter
    private lateinit var modalidadSelect: ModalidadServicio
    private lateinit var servicioById: Servicio
    private lateinit var listaModalidades: List<Modalidad>
    private lateinit var adapter: ModalidadServicioAdapter
    private  var lista=mutableListOf<ModalidadServicio>()
    private var listener :DataSet? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentSeleccionServicioBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= SeleccionServicioPresenter(this, requireContext())


        lifecycleScope.launch(Dispatchers.IO){
            inicializarRecycler()
        }
        /*
        withContext(Dispatchers.IO) {

            }
         */

        return builder.create()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Activity) {
            actividad = context
            if (actividad is DataSet) {
                listener = actividad as DataSet
            }
        } else {
            throw RuntimeException("$context debe implementar OnTextViewDataSet")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSeleccionServicioBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        fun onDataSetServicio(modalidad: ModalidadServicio)
    }

    private suspend fun inicializarRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        presenter.consultarModalidad()
        adapter= ModalidadServicioAdapter(lista,this)
        binding.recycler.adapter= adapter
    }
    override fun mostrarLista(list: List<Modalidad>) {
        listaModalidades= list
        crearLista()
    }

    private fun crearLista(){
        var contador=0
        for(list in listaModalidades){
            lifecycleScope.launch(Dispatchers.IO){
                presenter.consultarServicioById(list.id_servicio)
                withContext(Dispatchers.IO) {
                    var modalidad=list
                    var servicio= servicioById
                    var elemento= ModalidadServicio(modalidad,servicio)
                    lista.add(elemento)
                    contador++
                }
            }
        }
    }

    override fun mostrarServicioById(servicio: Servicio) {
        servicioById= servicio
    }

    override fun item(modalidad: ModalidadServicio) {
        listener?.onDataSetServicio(modalidad)
        dismiss()
    }

}