package com.example.bincheker.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bincheker.model.FullData
import com.example.bincheker.repository.BinsDBRepository
import com.example.bincheker.repository.BinsDBRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class BinsViewModel {
    private val binsDBRepository: BinsDBRepository = BinsDBRepositoryImpl()

    private val detailBinData = MutableLiveData<FullData?>()
    val detailsBinData: LiveData<FullData?> = detailBinData


    private val errorMessage = MutableLiveData<String>()
    val error:LiveData<String> = errorMessage

    fun getDataFromApi(input: String) {
        val response = binsDBRepository.getBinDetailsByNumber(input)
        val error = "пусто"
        response.enqueue(object : Callback<FullData> {
            override fun onResponse(call: Call<FullData>, response: Response<FullData>) {
                Log.d("BinsViewModel", "GG$response")
                detailBinData.postValue(response.body())
            }

            override fun onFailure(call: Call<FullData>, t: Throwable) {

                val message = when (t) {
                    is IOException -> "No internet connection"
                    is HttpException -> "Something went wrong!"
                    else -> t.localizedMessage
                }
                errorMessage.postValue(message)
                Log.d("sendLogs", "onFailure: $message")
            }
        })
    }
}