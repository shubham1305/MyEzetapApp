package com.example.myezetapapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CustomTextField(
    modifier: Modifier,
    hint: String,
    value: String,
    isNumberField: Boolean = false,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        singleLine = true,
        placeholder = {
            Text(text = hint)
        },
        keyboardOptions = if (isNumberField) KeyboardOptions(keyboardType = KeyboardType.Number) else KeyboardOptions.Default,
        onValueChange = onValueChange
    )
}