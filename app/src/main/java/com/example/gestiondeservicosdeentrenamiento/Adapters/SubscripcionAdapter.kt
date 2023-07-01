package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemSubscripcionBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.ClienteSubscripcion
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Modalidad
import com.example.gestiondeservicosdeentrenamiento.db.entidades.ModalidadServicio
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Subscripcion

class SubscripcionAdapter(private val items: MutableList<ClienteSubscripcion>, private val listenner:SubsListener
) : RecyclerView.Adapter<SubscripcionAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSubscripcionBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    interface SubsListener {
        fun onPagarClicked(subscription: ClienteSubscripcion)
        fun onCancelarClicked(subscription: ClienteSubscripcion)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class MyViewHolder(private val binding: ItemSubscripcionBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(subscription: ClienteSubscripcion) {
            binding.servicio.text= subscription.servicio.nombre
            binding.cliente.text= subscription.datosPersonales.nombre
            binding.monto.text= subscription.subscripcion.montoPago.toString()

            binding.cancelar.setOnClickListener {
               listenner.onCancelarClicked(subscription)
            }

            binding.guardar.setOnClickListener {
                listenner.onPagarClicked(subscription)
            }
        }
    }
}

