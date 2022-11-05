package com.example.myezetapapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myezetapapp.R
import com.example.myezetapapp.ui.components.CustomTextView

@Composable
fun CustomUIDetailPage(
    modifier: Modifier,
    data: List<String>
) {
    LazyColumn(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            CustomTextView(
                modifier = Modifier,
                text = stringResource(R.string.label_entered_data),
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(data) { value ->
            CustomTextView(modifier = Modifier, text = value)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}