package com.ekip.network

import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionsAPI {
    /**
     * @GET declares an HTTP GET request
     * @Path("limit") annotation on the limit parameter marks it as a
     * replacement for the {limit} placeholder in the @GET path
     */
    @GET("/questions?limit={limit}")
    suspend fun getQuestions(@Path("limit") limit: Int): List<Question>
}