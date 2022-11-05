package com.example.networkmodule.data.repository

import com.example.networkmodule.api.NetworkApi
import com.example.networkmodule.commons.NetworkConstants
import com.example.networkmodule.commons.NetworkResponse
import com.example.networkmodule.data.model.CustomImageModel
import com.example.networkmodule.data.model.CustomUIModel
import com.example.networkmodule.domain.repository.CustomUIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CustomUIRepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi
): CustomUIRepository {
    override fun fetchCustomUI(url: String): Flow<NetworkResponse<CustomUIModel>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val response = networkApi.fetchCustomUI()
            emit(NetworkResponse.Success(response))
        } catch (e: HttpException) {
            emit(NetworkResponse.Error(e.localizedMessage ?: NetworkConstants.ERROR_HTTP_EXCEPTION))
        } catch (e: IOException) {
            emit(NetworkResponse.Error(NetworkConstants.ERROR_IO_EXCEPTION))
        }
    }

    override fun fetchImage(url: String): Flow<NetworkResponse<CustomImageModel>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val response = networkApi.fetchImage()
            emit(NetworkResponse.Success(response))
        } catch (e: HttpException) {
            emit(NetworkResponse.Error(e.localizedMessage ?: NetworkConstants.ERROR_HTTP_EXCEPTION))
        } catch (e: IOException) {
            emit(NetworkResponse.Error(NetworkConstants.ERROR_IO_EXCEPTION))
        }
    }
}