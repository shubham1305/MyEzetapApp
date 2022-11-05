package com.example.networkmodule.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CustomImageModel(
    @SerializedName("logo-url")
    val logoUrl: String
)