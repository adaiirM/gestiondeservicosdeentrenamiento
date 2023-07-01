package com.example.gestiondeservicosdeentrenamiento.views.servicios

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.RegistrarModalidadPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentRegistrarModalidadBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarModalidadPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RegistrarModalidadFragment : DialogFragment() {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentRegistrarModalidadBinding
    private var listener :DataSet? = null
    private lateinit var presenter: IRegistrarModalidadPresenter
    private var id_servicio: Int=0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentRegistrarModalidadBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= RegistrarModalidadPresenter(requireContext())

        val bundle = arguments
        if (bundle != null) {
            id_servicio = bundle.getInt("id_servicio")
        }
        System.out.println("El id_servicio es: "+ id_servicio)

        llenarSpinner()

        binding.guardar.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                presenter.insertar(obtenerDatos())
            }
            listener?.onDataSet(true)
            dismiss()
        }

        binding.cancelar.setOnClickListener {
            dismiss()
        }

        return builder.create()
    }

    private fun obtenerDatos(): Modalidad {
        val presio= binding.precio.text.toString()
        val modo= binding.spinner.selectedItem.toString()
        System.out.println("El modo es: "+ modo)
        val modalidad= Modalidad(modo,presio.toDouble(),id_servicio)
        return modalidad
    }

    private fun llenarSpinner() {
        val elementos = listOf("Selecciona la subscripcion","Día","Semana","Mes")
        val opcionesAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, elementos)
        opcionesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = opcionesAdapter
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
        val binding = FragmentRegistrarModalidadBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        fun onDataSet(estado: Boolean)
    }
}