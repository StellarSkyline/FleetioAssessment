package com.example.fleetioassessment.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.fleetioassessment.ui.theme.ProjectColors

@Composable
fun TextLabel(
    modifier: Modifier = Modifier,
    label:String = "",
    content:String = "",
) {
    Text(
        text = "$label: $content",
        color = ProjectColors.dark_gray,
        fontSize = 16.sp,
        maxLines = 1
    )
}