package com.example.gestiondeservicosdeentrenamiento.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeservicosdeentrenamiento.databinding.ItemInformacionBinding
import com.example.gestiondeservicosdeentrenamiento.db.entidades.Codigo

class RecyclerViewAdapter(private val listCod:List<Codigo>):  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(),View.OnClickListener  {
    lateinit var listener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInformacionBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.setOnClickListener(this)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.obtenerData(listCod.get(position))
    }

    override fun getItemCount(): Int {
        return listCod.size
    }


    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener
    }

    override fun onClick(v: View?) {
        if (listener != null){
            listener.onClick(v)
        }
    }
    //lateinit var view.

    class ViewHolder(@NonNull bindig: ItemInformacionBinding): RecyclerView.ViewHolder(bindig.root) {
        var binding: ItemInformacionBinding= bindig

        fun obtenerData(codigo: Codigo) {
            binding.idElement.text = codigo.id.toString()
            binding.asentamiento.text = codigo.asentamiento
            binding.ciudad.text = codigo.ciudad
            binding.cp.text = codigo.cp
            binding.estado.text = codigo.estado
            binding.municipio.text = codigo.municipio
        }


    }

}