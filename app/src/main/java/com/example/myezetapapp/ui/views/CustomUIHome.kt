package com.example.myezetapapp.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myezetapapp.ui.CustomViewTypes
import com.example.myezetapapp.ui.UiState
import com.example.myezetapapp.ui.components.CustomButton
import com.example.myezetapapp.ui.components.CustomTextField
import com.example.myezetapapp.ui.components.CustomTextView
import com.example.networkmodule.data.model.UiData

@Composable
fun CustomUIHome(
    modifier: Modifier,
    uiState: UiState,
    responseData: HashMap<String, String>,
    onDataEntered: (String, String) -> Unit,
    onSubmit: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .padding(16.dp)
    ) {
        if (uiState.customUIModel == null && uiState.error != null) {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center),
                text = uiState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center
            )
        } else {
            val customUIModel = uiState.customUIModel

            customUIModel?.let {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = customUIModel.headingText,
                            style = MaterialTheme.typography.h6.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    item {
                        Image(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            painter = rememberAsyncImagePainter(
                                remember(customUIModel.logoUrl) {
                                    ImageRequest.Builder(context)
                                        .data(customUIModel.logoUrl)
                                        .placeholder(com.example.myezetapapp.R.drawable.placeholder_image)
                                        .error(com.example.myezetapapp.R.drawable.placeholder_image)
                                        .build()
                                }
                            ),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    items(customUIModel.uiData) { uiData ->
                        GetCustomView(
                            modifier = Modifier.fillMaxWidth(),
                            uiData = uiData,
                            responseData = responseData,
                            enteredData = onDataEntered,
                            onSubmitClick = onSubmit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }

            if (uiState.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}


@Composable
fun GetCustomView(
    modifier: Modifier,
    uiData: UiData,
    responseData: HashMap<String, String>,
    enteredData: (String, String) -> Unit,
    onSubmitClick: () -> Unit
) {
    when (uiData.uiType) {
        CustomViewTypes.TEXT_VIEW.value -> CustomTextView(modifier = modifier, text = uiData.value)
        CustomViewTypes.TEXT_FIELD.value -> {
            val text = remember { mutableStateOf(responseData[uiData.key] ?: "") }
            CustomTextField(
                modifier = modifier,
                hint = uiData.hint,
                value = text.value,
                isNumberField = uiData.key.equals("text_phone", true),
                onValueChange = {
                    text.value = it
                    enteredData(uiData.key, it)
                })
        }
        CustomViewTypes.BUTTON.value -> CustomButton(modifier = modifier, label = uiData.value, onSubmitClick)
    }
}