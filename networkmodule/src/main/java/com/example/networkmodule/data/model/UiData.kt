package com.example.networkmodule.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UiData(
    @SerializedName("hint")
    val hint: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("uitype")
    val uiType: String,
    @SerializedName("value")
    val value: String
)