package com.ekip.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuestionsNetwork {
    val retrofit: QuestionsAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://quizapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionsAPI::class.java)
    }
}