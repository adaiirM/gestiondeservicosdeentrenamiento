package com.example.gestiondeservicosdeentrenamiento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gestiondeservicosdeentrenamiento.databinding.ActivityMainBinding
import com.example.gestiondeservicosdeentrenamiento.views.PagosActivity
import com.example.gestiondeservicosdeentrenamiento.views.clientes.ClientesActivity
import com.example.gestiondeservicosdeentrenamiento.views.servicios.ServiciosActivity
import com.example.gestiondeservicosdeentrenamiento.views.subscripciones.SubscripcionesActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)

        binding.servicios.setOnClickListener {
            val intent= Intent(this, ServiciosActivity::class.java)
            startActivity(intent)

        }

        binding.clientes.setOnClickListener {
            val intent= Intent(this, ClientesActivity::class.java)
            startActivity(intent)

        }
        binding.registros.setOnClickListener {
            val intent= Intent(this, SubscripcionesActivity::class.java)
            startActivity(intent)

        }

        binding.pagos.setOnClickListener {
            val intent= Intent(this, PagosActivity::class.java)
            startActivity(intent)
        }

    }
}