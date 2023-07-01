package com.example.gestiondeservicosdeentrenamiento.views.servicios

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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentEditarServicioBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarServicioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarServicioView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditarServicioFragment : DialogFragment(), EditarServicioView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentEditarServicioBinding
    private lateinit var presenter: IEditarServicioPresenter
    private lateinit var servicioEdit: Servicio
    private var id: Int=0
    private var listener :DataSet? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentEditarServicioBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarServicioPresenter(this, requireContext())

        val bundle = arguments
        if (bundle != null) {
            id = bundle.getInt("id_servicio")
        }
        System.out.println("El id_servicio es: "+ id)
        lifecycleScope.launch(Dispatchers.IO){
            presenter.obtenerServicioPorId(id)
        }


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
        val binding = FragmentEditarServicioBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }
    private fun guardar(){
        binding.guardar.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                obtenerCampos()
                presenter.actualizar(servicioEdit)
            }
            dismiss()
        }
    }

    private fun cancelar(){
        binding.cancelar.setOnClickListener {
            dismiss()
        }
    }
    private fun obtenerCampos(){
        val nombre=binding.nombre.text.toString()
        val descripcion=binding.descripcion.text.toString()
        servicioEdit.nombre=nombre
        servicioEdit.descripcion=descripcion
    }

    override fun mostrarServicio(servicio: Servicio) {
        servicioEdit=servicio
        llenarCampos()
        guardar()
        cancelar()
    }
    private fun llenarCampos(){
        //runOnUiThread {
        activity?.runOnUiThread {
            if (::servicioEdit.isInitialized) {
                binding.nombre.setText(servicioEdit.nombre.toString())
                binding.descripcion.setText(servicioEdit.descripcion.toString())
            }
        }
        //}
    }

}