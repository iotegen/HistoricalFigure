package com.example.androidlab2.network

import com.example.androidlab2.model.HistoricalFigure
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

object ApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(ApiService::class.java)

    interface ApiService {
        @Headers("X-Api-Key: yxPt5ADDKYT+iq5bW4ezOw==NhsJ6dNtgD1cktZQ")
        @GET("historicalfigures")
        fun getHistoricalFigure(@Query("name") name: String): Call<List<HistoricalFigure>>
    }

}