package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemSevicioBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Servicio

class ServicioAdapter(private val servicios: List<Servicio>, private val listener: ServicioListener) : RecyclerView.Adapter<ServicioAdapter.ServicioHolder>() {

    interface ServicioListener {
        fun onServicioSelectedEdit(servicio: Servicio)
        fun onServicioSelectedDelete(servicio: Servicio)
        fun onServicioSelectedItem(servicio: Servicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioHolder {
        val binding = ItemSevicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicioHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicioHolder, position: Int) {
        val servicio = servicios[position]
        holder.bind(servicio)
    }

    override fun getItemCount(): Int = servicios.size

    inner class ServicioHolder(private val binding: ItemSevicioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(servicio: Servicio) {
            // Establece los valores del servicio en la vista
            binding.nombreServicio.text = servicio.nombre
            binding.descripcion.text = servicio.descripcion
            binding.botonEditar.setOnClickListener {
                listener.onServicioSelectedEdit(servicio)
            }
            binding.botonEliminar.setOnClickListener {
                listener.onServicioSelectedDelete(servicio)
            }

            binding.root.setOnClickListener {
                listener.onServicioSelectedItem(servicio)
            }
        }
    }
}
