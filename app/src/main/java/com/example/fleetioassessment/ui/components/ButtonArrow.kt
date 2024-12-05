package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fleetioassessment.ui.theme.ProjectColors

@Composable
fun ButtonArrow(
    modifier: Modifier = Modifier,
    arrowDirection: String = "right",
    isEnabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    val icon =
        when(arrowDirection) {
            "left" -> Icons.Default.KeyboardArrowLeft
            "right" -> Icons.Default.KeyboardArrowRight
            else -> Icons.Default.Close
        }
    //Supposed to handle isEnabled/Disabled Color
    val color = if (isEnabled) ProjectColors.color_green else ProjectColors.neutral_black

    Icon(
        modifier = modifier
            .size(50.dp)
            .clickable { onClick() },
        imageVector = icon,
        contentDescription = "Arrow Button",
        tint = color
    )

}

@Composable
@Preview
fun ButtonArrowPreview() {
    ButtonArrow()
}