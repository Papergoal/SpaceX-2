package com.example.spacex.infosTest

import retrofit2.Call
import retrofit2.http.GET

interface CocktailWebservice{
    @GET("https://api.spacexdata.com/v3/info")
    fun getRandomInfo(): Call<InfoResponse>
}