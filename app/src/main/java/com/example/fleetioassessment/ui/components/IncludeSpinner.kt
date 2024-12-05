package com.example.fleetioassessment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fleetioassessment.ui.theme.ProjectColors
import kotlinx.coroutines.delay

@Preview
@Composable
fun IncludeSpinner(modifier: Modifier = Modifier) {
    //Handles error state when there is no search result

    val state = remember { mutableStateOf(true) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (state.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp),
                    color = ProjectColors.color_green,
                    trackColor = ProjectColors.dark_gray
                )
            }
        } else {
            Text(
                text = "No Search Result Found",
                color = ProjectColors.red,
                fontSize = 30.sp,
            )
        }

        LaunchedEffect(Unit) {
            delay(3000)
            state.value = false
        }
    }
}