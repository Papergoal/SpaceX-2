package com.example.spacex.infosTest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class HistoryService constructor(
    private val webService: HistoryWebServices
) {
    fun getRandomHistory(onDone:(History)->Unit, onError: (Throwable)->Unit){
        webService.getRandomHistory().enqueue(object : Callback<HistoryResponse> {
            override fun onResponse(
                call: Call<HistoryResponse>,
                response: Response<HistoryResponse>
            ){
                Random(Int.MAX_VALUE)
                val historyResponse=response.body()
                val history: History = historyResponse!!.docs[Random.nextInt(0, 8)]
                onDone(history)
            }
            override fun onFailure(call: Call<HistoryResponse>, t:Throwable){
                onError(t)
            }
        })
    }
}