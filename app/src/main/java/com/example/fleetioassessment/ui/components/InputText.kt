package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String = "",
    label: String = "",
    onChange: (String) -> Unit,
    onAction: () -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        value = text,
        label = {
            Text(label, maxLines = 1)
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions {
            onAction()
            keyboardController?.hide()
        },
        colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White),
        onValueChange = {
            onChange(it)
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = Color.Black
        ),
    )
}