package com.example.fleetioassessment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun HomeScreen(vm:VehicleViewModel, onNavigate: (String) -> Unit) {


    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {

        Text(
            text = "HELLO WORD",
            fontSize = 70.sp,
            color = Color.Blue
        )
    }


}