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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.SeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentSeleccionClienteBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.ISeleccionClientePresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.SeleccionClienteView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SeleccionClienteFragment : DialogFragment(), SeleccionClienteView, ClienteAdapter.OnItemClickListener{
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentSeleccionClienteBinding
    private lateinit var presenter: ISeleccionClientePresenter
    private lateinit var lista: List<DatosPersonales>
    private lateinit var clienteSelect: DatosPersonales
    private lateinit var adapter: ClienteAdapter
    private var listener :DataSet? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentSeleccionClienteBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= SeleccionClientePresenter(this, requireContext())


        lifecycleScope.launch(Dispatchers.IO) {
            inicializarRecycler()
        }


        return builder.create()
    }

    private suspend fun inicializarRecycler(){
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        presenter.obtenerTodosLosDatosPersonales()
        adapter= ClienteAdapter(lista,this)
        binding.recycler.adapter= adapter
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
        val binding = FragmentSeleccionClienteBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        fun onDataSetCliente(cliente: DatosPersonales)
    }

    override fun mostrar(list: List<DatosPersonales>) {
        lista= list
    }

    override fun onItemClick(item: DatosPersonales) {
        clienteSelect= item
        listener?.onDataSetCliente(clienteSelect)
        dismiss()
    }

}