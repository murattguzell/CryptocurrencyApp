package com.muratguzel.kriptopara.service

import com.muratguzel.kriptopara.model.CyriptoModel
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Call
import retrofit2.http.GET


interface CyriptoAPI {
    //GET, POST, UPDATE, DELETE

    @GET(value = "atilsamancioglu/K21-JSONDataSet/master/crypto.json")
   // fun getData(): Call<List<CyriptoModel>>
    fun getData(): Observable<List<CyriptoModel>>



}