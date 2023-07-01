package com.example.ejecicio.utils

class Apis {
    companion object{
        //var URL001: String="http://192.168.0.101:8083/code/"
        var URL001: String="http://172.25.22.98:8083/code/"

        fun getCodigoService(): CodigoService {
            return Cliente.getCliente(URL001).create(CodigoService::class.java)
        }
    }


}