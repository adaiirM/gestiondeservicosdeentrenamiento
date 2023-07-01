package com.example.gestiondeservicosdeentrenamiento.views

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejecicio.utils.Apis
import com.example.ejecicio.utils.CodigoService
import com.example.gestiondeservicosdeentrenamiento.Adapters.RecyclerViewAdapter
import com.example.gestiondeservicosdeentrenamiento.Models.presenters.EditarUbicacionPresenter
import com.example.gestiondeservicosdeentrenamiento.R
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentDatosUbicacionBinding
import com.example.gestiondeservicosdeentrenamiento.databinding.FragmentUnicacionBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Codigo
import com.example.gestiondeservicosdeentrenamiento.views.clientes.DatosUbicacionFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UnicacionFragment : DialogFragment() {
    private lateinit var binding: FragmentUnicacionBinding
    private lateinit var codigoService: CodigoService
    private lateinit var listCodigo: List<Codigo>
    private lateinit var actividad: Activity

    private var listener : DataSet? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return lista()
    }

    private fun lista(): Dialog {
        binding = FragmentUnicacionBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        construirRecycler()

        return builder.create()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentUnicacionBinding.inflate(inflater, container, false)
        return binding.root
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
    interface DataSet {
        fun dataSet(codigo: Codigo)
    }



    private fun  construirRecycler(){
        listCodigo=ArrayList()
        codigoService= Apis.getCodigoService()
        val call: retrofit2.Call<List<Codigo>> = codigoService.getCodigo()


        call.enqueue(object:retrofit2.Callback<List<Codigo>>{
            override fun onResponse(call: retrofit2.Call<List<Codigo>>, response: retrofit2.Response<List<Codigo>>) {
                if (response.isSuccessful){
                    listCodigo = response.body()!!
                    binding.rview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
                    var adapterCodigo: RecyclerViewAdapter = RecyclerViewAdapter(listCodigo)

                    adapterCodigo.setOnClickListener(View.OnClickListener { v ->
                        val position = binding.rview.getChildAdapterPosition(v)
                        listener?.dataSet(listCodigo[position])
                        System.out.println("El codigo es: "+ listCodigo[position].estado)
                        dismiss()
                    })
                    System.out.println("El adapter tie elementos:"+ listCodigo.size)
                    binding.rview.adapter =adapterCodigo

                }
            }

            override fun onFailure(call: retrofit2.Call<List<Codigo>>, t: Throwable) {
                Log.e("Error:", t.message.toString())
            }

        })
    }

}