package com.example.networkmodule.domain.repository

import com.example.networkmodule.commons.NetworkResponse
import com.example.networkmodule.data.model.CustomImageModel
import com.example.networkmodule.data.model.CustomUIModel
import kotlinx.coroutines.flow.Flow

interface CustomUIRepository {

    fun fetchCustomUI(url: String): Flow<NetworkResponse<CustomUIModel>>

    fun fetchImage(url: String): Flow<NetworkResponse<CustomImageModel>>
}