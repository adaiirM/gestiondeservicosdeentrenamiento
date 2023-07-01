package com.example.gestiondeservicosdeentrenamiento.views.servicios

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.fragment.app.DialogFragment
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarModalidadPresenter
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentEditarModalidadBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.interfaces.presenters.IEditarModalidadPresenter
import com.example.gestiondeservicosdeentrenamiento.interfaces.views.EditarModalidadView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditarModalidadFragment : DialogFragment(), EditarModalidadView {
    private lateinit var actividad: Activity
    private lateinit var binding: FragmentEditarModalidadBinding
    private lateinit var presenter: IEditarModalidadPresenter
    private var listener :DataSet? = null
    private var id_modalidad: Int=0
    private lateinit var modalidadEdit: Modalidad

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentEditarModalidadBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        presenter= EditarModalidadPresenter(this, requireContext())
        val bundle = arguments
        if (bundle != null) {
            id_modalidad = bundle.getInt("id_modalidad")
        }
        System.out.println("El id_servicio es: "+ id_modalidad)

        lifecycleScope.launch(Dispatchers.IO){
            presenter.obtenerModalidadPorId(id_modalidad)
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
        val binding = FragmentEditarModalidadBinding.inflate(inflater, container, false)
        return binding.root
    }
    interface DataSet {
        //fun onDataSet(cliente: Cliente)
    }

    override fun mostrarModalidad(modalidad: Modalidad) {
        modalidadEdit=modalidad
        if (modalidad!=null){

                llenarCampos()
                guardar()
                cancelar()

        }
    }

    private fun guardar(){
        binding.guardar.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){
                obtenerCampos()
                presenter.actualizar(modalidadEdit)
            }
            dismiss()
        }
    }

    private fun cancelar(){
        binding.cancelar.setOnClickListener {
            dismiss()
        }
    }

    private fun llenarCampos(){
        //runOnUiThread {
        if(::modalidadEdit.isInitialized){
            activity?.runOnUiThread{
                binding.precio.setText(modalidadEdit.precio.toString())
            }

        }
        //}
    }
    private fun obtenerCampos(){

            val precio=binding.precio.text.toString()
            modalidadEdit.precio= precio.toDouble()

    }

}