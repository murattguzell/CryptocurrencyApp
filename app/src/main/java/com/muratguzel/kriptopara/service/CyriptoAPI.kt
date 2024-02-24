package com.muratguzel.kriptopara.service

import com.muratguzel.kriptopara.model.CyriptoModel
import retrofit2.Call
import retrofit2.http.GET


interface CyriptoAPI {
    //GET, POST, UPDATE, DELETE

    @GET(value = "atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Call<List<CyriptoModel>>


}