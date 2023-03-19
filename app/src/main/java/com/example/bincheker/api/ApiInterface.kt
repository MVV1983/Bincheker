package com.example.bincheker.api

import com.example.bincheker.model.FullData
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("{number}")
    fun sendPost(@Path("number") number: String): Call<FullData>
}