package com.example.fleetioassessment.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fleetioassessment.ui.components.DetailsPicture
import com.example.fleetioassessment.ui.components.DisplayItem
import com.example.fleetioassessment.ui.components.TopBar
import com.example.fleetioassessment.ui.navigation.Screen
import com.example.fleetioassessment.ui.theme.ProjectColors
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun DetailsScreen(
    vm: VehicleViewModel,
    onNavigate: (String) -> Unit
) {
    //getRecord Details
    val record = vm.getRecord()
    val displayDetails = vm.getDisplayDetails()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(ProjectColors.dark_gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            TopBar(
                modifier = Modifier
                    .fillMaxWidth(),
                arrowDirection = "left",
                route = Screen.HomeScreen.route,
                title = "Vehicle Details",
                textColor = ProjectColors.light_gray
            ) {
                onNavigate(it)
            }
            Spacer(modifier = Modifier.height(10.dp))
            DetailsPicture(url = record.default_image_url_small)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(vm.getDisplayDetails().size) {
                DisplayItem(
                    title = displayDetails[it].first,
                    content = displayDetails[it].second
                )
            }

        }

    }
}