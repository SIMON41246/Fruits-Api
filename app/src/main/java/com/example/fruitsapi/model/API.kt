package com.example.fruitsapi.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface fruitsapiservice {
    @GET("all")
    fun getFruits(): Call<MutableList<FruitsInfoItem>>
}

object API {
    private val BASE_URL = "https://fruityvice.com/api/fruit/"
    private val apiservice = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val result = apiservice.create(fruitsapiservice::class.java)
}
