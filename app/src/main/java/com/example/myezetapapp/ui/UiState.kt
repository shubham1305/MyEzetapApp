package com.example.myezetapapp.ui

import androidx.annotation.Keep
import com.example.networkmodule.data.model.CustomUIModel

@Keep
data class UiState(
    val isLoading: Boolean = false,
    val customUIModel: CustomUIModel? = null,
    val error: String? = null,
)