package com.example.bincheker.repository

import com.example.bincheker.api.RetrofitClient
import com.example.bincheker.model.FullData
import retrofit2.Call

class BinsDBRepositoryImpl : BinsDBRepository {

    //обращаемся в API и возвращаем результат
    override fun getBinDetailsByNumber(input: String): Call<FullData> {
        return RetrofitClient.create().sendPost(input)
    }
}