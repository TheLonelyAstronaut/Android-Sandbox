package com.thelonelyastronaut.kmweather.android.components.text

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun CustomTextInput(
    value: MutableState<String>,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = onValueChange,
        label = { Text("Choose location...") },
        singleLine = true
    )
}