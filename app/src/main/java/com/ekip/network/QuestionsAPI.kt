package com.ekip.network

import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsAPI {
    @GET("questions")
    suspend fun getQuestions(@Query("apiKey") apiKey: String, @Query("limit") limit: Int = 10): List<Question>

    @GET("questions")
    suspend fun getQuestionsByCategory(@Query("apiKey") apiKey: String, @Query("category") category: String): List<Question>

}