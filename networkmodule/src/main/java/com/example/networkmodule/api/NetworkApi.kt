package com.example.networkmodule.api

import com.example.networkmodule.data.model.CustomImageModel
import com.example.networkmodule.data.model.CustomUIModel
import retrofit2.http.GET

interface NetworkApi {

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchCustomUI(): CustomUIModel

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchImage(): CustomImageModel
}