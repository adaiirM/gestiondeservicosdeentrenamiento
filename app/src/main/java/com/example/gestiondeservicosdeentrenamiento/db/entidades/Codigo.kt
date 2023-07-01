package com.example.gestiondeservicosdeentrenamiento.db.entidades

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Codigo{
    @SerializedName("id")
    @Expose
    var id: Long=0

    @SerializedName("asentamiento")
    @Expose
    lateinit var asentamiento: String
    @SerializedName("municipio")
    @Expose
    lateinit var municipio: String
    @SerializedName("estado")
    @Expose
    lateinit var estado: String
    @SerializedName("ciudad")
    @Expose
    lateinit var ciudad: String
    @SerializedName("codigo")
    @Expose
    lateinit var cp: String

    constructor(){

    }
    constructor(id:Long,asentamiento: String, municipio: String,estado: String, ciudad:String, cp:String  ){
        this.id=id
        this.ciudad=ciudad
        this.asentamiento=asentamiento
        this.municipio=municipio
        this.estado=estado
        this.cp=cp
    }

    constructor(asentamiento: String, municipio: String, estado: String, ciudad: String, cp: String){
        this.ciudad=ciudad
        this.asentamiento=asentamiento
        this.municipio=municipio
        this.estado=estado
        this.cp=cp
    }


}
