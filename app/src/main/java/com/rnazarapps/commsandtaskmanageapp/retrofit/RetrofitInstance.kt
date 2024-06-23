package com.rnazarapps.commsandtaskmanageapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://localhost:5999/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val taskApi: TaskApi by lazy {
        retrofit.create(TaskApi::class.java)
    }

    val messageApi: MessageApi by lazy {
        retrofit.create(MessageApi::class.java)
    }
}