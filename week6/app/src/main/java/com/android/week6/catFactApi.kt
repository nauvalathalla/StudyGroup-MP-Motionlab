package com.android.week6

import retrofit2.http.GET

interface CatFactsApi {
    @GET("fact")
    suspend fun getRandomFact(): CatFact
}