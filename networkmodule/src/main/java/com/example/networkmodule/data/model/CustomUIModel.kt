package com.example.networkmodule.data.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CustomUIModel(
    @SerializedName("heading-text")
    val headingText: String,
    @SerializedName("logo-url")
    val logoUrl: String,
    @SerializedName("uidata")
    val uiData: List<UiData>
)