package com.example.bincheker.model

import com.google.gson.annotations.SerializedName

data class Number(
    @SerializedName("length") var length: Int,
    @SerializedName("luhn") var luhn: Boolean
)