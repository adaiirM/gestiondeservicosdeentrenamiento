package com.example.gestiondeservicosdeentrenamiento.views.clientes

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarUbicacionPresenter
import com.example.gestiondeservicosdeentrenamiento.R
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosPersonalesBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosUbicacionBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Ubicacion
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarUbicacionPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarUbicacionView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DatosUbicacionFragment : DialogFragment(), EditarUbicacionView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentDatosUbicacionBinding
    private lateinit var presenter: IEditarUbicacionPresenter
    private lateinit var dato: Ubicacion
    private var listener :DataSet? = null
    private var id: Int=0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentDatosUbicacionBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarUbicacionPresenter(this, requireContext())

        val bundle = arguments
        if (bundle != null) {
            id = bundle.getInt("id_cliente")
        }

        lifecycleScope.launch(Dispatchers.IO){
            presenter.consultar(id)
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
        val binding = FragmentDatosUbicacionBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }

    override fun mostrar(ubicacion: Ubicacion) {
        dato= ubicacion
        llenarCampos()
        guardar()
        cancelar()
    }

    private fun llenarCampos(){
        activity?.runOnUiThread {
            if (::dato.isInitialized) {
                binding.colonia.setText(dato.colonia)
                binding.cp.setText(dato.cp)
                binding.estado.setText(dato.estado)
            }
        }
    }

    private fun guardar(){
        binding.guardar.setOnClickListener {
            dato.cp= binding.cp.text.toString()
            dato.estado=binding.estado.text.toString()
            dato.colonia=binding.colonia.text.toString()

            lifecycleScope.launch(Dispatchers.IO){
                presenter.update(dato)
            }
            dismiss()
        }
    }

    private fun cancelar(){
        binding.cancelar.setOnClickListener {
            dismiss()
        }
    }

}