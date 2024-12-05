package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fleetioassessment.ui.theme.ProjectColors

@Composable
fun DisplayItem(
    modifier: Modifier = Modifier,
    title: String = "",
    content: String = "",
    onClick: (String) -> Unit = {}
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(ProjectColors.light_gray)
            .border(width = 1.dp, color = ProjectColors.color_green),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = ProjectColors.dark_gray
            )
            Text(
                text = content,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Spacer(Modifier.weight(1f))
        Icon(
            modifier = modifier
                .size(50.dp)
                .clickable { onClick("Edit") }
                .padding(end = 16.dp),
            imageVector = Icons.Default.Create,
            contentDescription = "Arrow Button",
            tint = ProjectColors.dark_gray
        )
    }
}

@Composable
@Preview
fun DisplayItemPreview() {
    DisplayItem(
        title = "Title",
        content = "Content"
    )
}