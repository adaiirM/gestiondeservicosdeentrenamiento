package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemListSeleccionClienteBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.DatosPersonales

class ClienteAdapter (val datos: List<DatosPersonales>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ClienteAdapter.ViewHolder>() {

    // Interface para gestionar los eventos de clic
    interface OnItemClickListener {
        fun onItemClick(item: DatosPersonales)
    }

    // Clase ViewHolder que enlaza los elementos con el modelo de datos
    inner class ViewHolder(val binding: ItemListSeleccionClienteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DatosPersonales, listener: OnItemClickListener) {
            binding.nombre.text = item.nombre+" "+ item.apellido_m+" "+item.apellido_p
            binding.cardViewListenerAdeudos.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    // Crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListSeleccionClienteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    // Actualiza el contenido del ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datos[position], listener)
    }

    // Devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int {
        return datos.size
    }
}
