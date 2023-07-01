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
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.RegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentRegistrarServicioBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IRegistrarServcioPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.RegistrarServicioView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrarServicioFragment : DialogFragment(), RegistrarServicioView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentRegistrarServicioBinding
    private var listener :DataSet? = null
    private lateinit var presenter: IRegistrarServcioPresenter


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentRegistrarServicioBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= RegistrarServcioPresenter(this, requireContext())

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

    private fun obtenerDatos():Servicio{
        val nombre= binding.nombre.text.toString()
        val descripcion= binding.descripcion.text.toString()
        val servicio= Servicio(nombre,descripcion)
        return servicio
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
        val binding = FragmentRegistrarServicioBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        fun onDataSet(estado: Boolean)
    }

    override suspend fun mostrarServicioPorId(servicio: Servicio) {
        TODO("Not yet implemented")
    }

    override suspend fun mostrarTodosLosServicios(lis: List<Servicio>) {
        TODO("Not yet implemented")
    }

}