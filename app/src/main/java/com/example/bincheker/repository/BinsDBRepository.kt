package com.example.bincheker.repository

import com.example.bincheker.model.FullData
import retrofit2.Call

interface BinsDBRepository {
    //возвращаем данные  BIN по номеру
    fun getBinDetailsByNumber(input: String): Call<FullData>
}