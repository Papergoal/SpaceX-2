package com.example.spacex.infosTest

import retrofit2.Call
import retrofit2.http.GET

interface HistoryWebServices{
    @GET("/api/v1/articles")
    fun getRandomHistory(): Call<HistoryResponse>
}