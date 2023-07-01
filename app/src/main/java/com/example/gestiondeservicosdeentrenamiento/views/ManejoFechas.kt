package com.example.gestiondeservicosdeentrenamiento.views

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ManejoFechas {
    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun fechaDate(string: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return LocalDate.parse(string, formatter)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarDiaFechas(fecha:String, cantidad:Int): LocalDate? {
        val f= fechaDate(fecha)
        return f.plusDays(cantidad.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarSemanaFechas(fecha:String, cantidad:Int): LocalDate? {
        val f= fechaDate(fecha)
        return f.plusWeeks(cantidad.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(Exception::class)
    private fun sumarMesFechas(fecha:String, cantidad:Int): LocalDate? {
        val f= fechaDate(fecha)
        return f.plusMonths(cantidad.toLong())
    }
}