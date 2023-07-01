package com.example.gestiondeservicosdeentrenamiento.views.clientes

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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarContactoPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosContatoBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Contacto
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarContactoPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarContactoView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatosContatoFragment : DialogFragment(),EditarContactoView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentDatosContatoBinding
    private lateinit var presenter: IEditarContactoPresenter
    private lateinit var dato: Contacto
    private var listener :DataSet? = null
    private var id: Int = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentDatosContatoBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarContactoPresenter(this, requireContext())


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
        val binding = FragmentDatosContatoBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }

    override fun mostrarDato(contacto: Contacto) {
        dato= contacto
        llenarCampos()
        guardar()
        cancelar()
    }

    private fun llenarCampos(){
        activity?.runOnUiThread {
            if (::dato.isInitialized) {
                binding.telefono.setText(dato.telefono)
                binding.correo.setText(dato.correo)
            }
        }
    }

    private fun guardar(){
        binding.guardar.setOnClickListener {
            dato.telefono= binding.telefono.text.toString()
            dato.correo=binding.correo.text.toString()

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