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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarDatosMPresenter
import com.example.gestiondeservicosdeentrenamiento.R
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosContatoBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosMedicosBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosMedicos
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosMPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarDatosMView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DatosMedicosFragment : DialogFragment(), EditarDatosMView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentDatosMedicosBinding
    private lateinit var presenter: IEditarDatosMPresenter
    private lateinit var dato: DatosMedicos
    private var listener :DataSet? = null
    private var id: Int =0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentDatosMedicosBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarDatosMPresenter(this, requireContext())

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
        val binding = FragmentDatosMedicosBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }

    override fun mostrar(datosMedicos: DatosMedicos) {
        dato= datosMedicos
        llenarCampos()
        guardar()
        cancelar()
    }

    private fun llenarCampos(){
        activity?.runOnUiThread {
            if (::dato.isInitialized) {
                binding.presion.setText(dato.presion_arterial)
                binding.medicacion.setText(dato.consumo_medicamento)
                binding.edad.setText(dato.edad.toString())
                binding.peso.setText(dato.peso.toString())
                binding.estatura.setText(dato.estatura.toString())
                binding.padecimiento.setText(dato.padecimiento)
            }
        }
    }

    private fun guardar(){
        binding.guardar.setOnClickListener {
            dato.edad= binding.edad.text.toString().toInt()
            dato.peso=binding.peso.text.toString().toDouble()
            dato.estatura= binding.estatura.text.toString().toDouble()
            dato.presion_arterial= binding.presion.text.toString()
            dato.consumo_medicamento= binding.medicacion.toString()
            dato.padecimiento= binding.padecimiento.text.toString()

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