package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemClienteBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

class DatosPersonalesAdapter(private val datosPersonalesList: List<DatosPersonales>, val listener:DatosListener) : RecyclerView.Adapter<DatosPersonalesAdapter.DatosPersonalesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosPersonalesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemClienteBinding.inflate(layoutInflater, parent, false)
        return DatosPersonalesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DatosPersonalesViewHolder, position: Int) {
        val datosPersonales = datosPersonalesList[position]
        holder.bind(datosPersonales)
    }

    override fun getItemCount(): Int {
        return datosPersonalesList.size
    }
    interface DatosListener {
        fun onEditClicked(datos: DatosPersonales)
        fun onDeleteClicked(datos: DatosPersonales)
    }

    inner class DatosPersonalesViewHolder(private val binding: ItemClienteBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(datosPersonales: DatosPersonales) {
            binding.nombre.text = datosPersonales.nombre

            binding.editar.setOnClickListener {
                listener.onEditClicked(datosPersonales)
            }
            binding.eliminar.setOnClickListener {
                listener.onDeleteClicked(datosPersonales)
            }
        }
    }
}