package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fleetioassessment.ui.theme.ProjectColors

@Composable
fun EditDetails(
    modifier: Modifier = Modifier,
    title: String = "",
    content: String = "String",
    onChange: (String) -> Unit = {},
    onAction: (String) -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Card(
            modifier = modifier
                .width(300.dp)
                .height(150.dp)
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(4.dp)

        ) {

            Column(
                modifier = Modifier
                    .background(ProjectColors.light_gray)
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Enter $title",
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(10.dp))

                InputText(
                    text = content,
                    label = title,
                    onChange = { onChange(it) }
                ) {
                    onAction("")
                }
            }
        }
    }

}

@Composable
@Preview
fun EditDetailsPreview() {
    EditDetails(title = "Title", content = "Content")
}