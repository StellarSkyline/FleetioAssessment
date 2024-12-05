package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fleetioassessment.ui.theme.ProjectColors

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    route: String = "",
    textColor: Color = ProjectColors.light_gray,
    arrowDirection: String = "left",
    onClick: (String) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonArrow(
            arrowDirection = arrowDirection,
            isEnabled = true,
        ) {
            onClick(route)
        }
        Text(
            text = title,
            color = textColor,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
    }
}