package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemModalidadBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad

class ModalidadAdapter(
    private val modalidades: List<Modalidad>,
    private val listener: ModalidadListener
) : RecyclerView.Adapter<ModalidadAdapter.ModalidadViewHolder>() {

    interface ModalidadListener {
        fun onEditClicked(modalidad: Modalidad)
        fun onDeleteClicked(modalidad: Modalidad)
    }

    inner class ModalidadViewHolder(private val binding: ItemModalidadBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modalidad: Modalidad) {
            binding.nombre.text = modalidad.nombre
            binding.presio.text = modalidad.precio.toString()

            binding.botonEditar.setOnClickListener {
                listener.onEditClicked(modalidad)
            }

            binding.botonEliminar.setOnClickListener {
                listener.onDeleteClicked(modalidad)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModalidadViewHolder {
        val binding =
            ItemModalidadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModalidadViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModalidadViewHolder, position: Int) {
        val modalidad = modalidades[position]
        holder.bind(modalidad)
    }

    override fun getItemCount(): Int = modalidades.size


}
