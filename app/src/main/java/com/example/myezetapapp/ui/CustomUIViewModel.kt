package com.example.myezetapapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkmodule.commons.NetworkResponse
import com.example.networkmodule.domain.repository.CustomUIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CustomUIViewModel @Inject constructor(
    private val customUIRepository: CustomUIRepository
) : ViewModel() {

    val response by mutableStateOf(HashMap<String, String>())
    var uiState by mutableStateOf(UiState())
        private set

    init {
        loadCustomUI()
    }

    private fun loadCustomUI(url: String = "") {
        customUIRepository.fetchCustomUI(url)
            .flowOn(Dispatchers.IO)
            .onEach {
                uiState = when(it) {
                    is  NetworkResponse.Loading -> {
                        uiState.copy(isLoading = true)
                    }
                    is NetworkResponse.Success -> {
                        uiState.copy(isLoading = false, customUIModel = it.data, error = null)
                    }
                    is NetworkResponse.Error -> {
                        uiState.copy(isLoading = false, customUIModel = null, error = it.message)
                    }
                }
        }.launchIn(viewModelScope)
    }

    private fun loadImage(url: String = "") {
        customUIRepository.fetchImage(url)
            .flowOn(Dispatchers.IO)
            .onEach {
                // TODO("To be implemented")
            }.launchIn(viewModelScope)
    }
}