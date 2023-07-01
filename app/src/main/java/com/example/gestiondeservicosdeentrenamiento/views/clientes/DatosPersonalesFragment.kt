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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarDatosPPresenter
import com.example.gestiondeservicosdeentrenamiento.R
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosMedicosBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosPersonalesBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarDatosPPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarDatosPView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DatosPersonalesFragment : DialogFragment(), EditarDatosPView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentDatosPersonalesBinding
    private lateinit var datosPersonalesEdit: DatosPersonales
    private lateinit var presenter: IEditarDatosPPresenter
    private var id: Int = 0
    private var listener :DataSet? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentDatosPersonalesBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarDatosPPresenter(this, requireContext())

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
        val binding = FragmentDatosPersonalesBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }

    override fun mostrarDatos(datosPersonales: DatosPersonales) {
        datosPersonalesEdit=datosPersonales
        llenarCampos()
        guardar()
        cancelar()
    }
    private fun llenarCampos(){
        activity?.runOnUiThread {
            if (::datosPersonalesEdit.isInitialized) {
                binding.nombre.setText(datosPersonalesEdit.nombre.toString())
                binding.apellidoM.setText(datosPersonalesEdit.apellido_m)
                binding.apellidoP.setText(datosPersonalesEdit.apellido_p)
            }
        }
    }

    private fun guardar(){
        binding.guardar.setOnClickListener {
            datosPersonalesEdit.nombre= binding.nombre.text.toString()
            datosPersonalesEdit.apellido_p= binding.apellidoP.text.toString()
            datosPersonalesEdit.apellido_m= binding.apellidoM.text.toString()
            lifecycleScope.launch(Dispatchers.IO){
                presenter.update(datosPersonalesEdit)
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