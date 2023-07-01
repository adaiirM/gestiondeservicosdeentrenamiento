package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemSelectServicioBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.ModalidadServicio

class ModalidadServicioAdapter(private val modalidadServicios: MutableList<ModalidadServicio>, private val onClick: itemOnClick) : RecyclerView.Adapter<ModalidadServicioAdapter.ModalidadServicioViewHolder>() {

    inner class ModalidadServicioViewHolder(private val binding: ItemSelectServicioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(modalidadServicio: ModalidadServicio) {
            binding.nombre.text = modalidadServicio.servicio.nombre+" "+modalidadServicio.modalidad.nombre

            binding.root.setOnClickListener {
                onClick.item(modalidadServicio)
            }
        }
    }
    interface itemOnClick{
        fun item(modalidad: ModalidadServicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModalidadServicioViewHolder {
        val binding = ItemSelectServicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModalidadServicioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModalidadServicioViewHolder, position: Int) {
        val modalidadServicio = modalidadServicios[position]
        holder.bind(modalidadServicio)
    }

    override fun getItemCount(): Int = modalidadServicios.size

}