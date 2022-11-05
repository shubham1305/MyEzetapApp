package com.example.myezetapapp.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun CustomTextView(
    modifier: Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.body1
) {
    Text(modifier = modifier, text = text, style = style)
}