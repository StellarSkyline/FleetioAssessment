package com.example.fleetioassessment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fleetioassessment.ui.components.DetailsPicture
import com.example.fleetioassessment.ui.components.DisplayItem
import com.example.fleetioassessment.ui.components.TopBar
import com.example.fleetioassessment.ui.navigation.Screen
import com.example.fleetioassessment.ui.theme.ProjectColors
import com.example.fleetioassessment.viewmodel.VehicleViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun DetailsScreen(
    vm: VehicleViewModel,
    onNavigate: (String) -> Unit
) {
    //getRecord Details
    val record = vm.getRecord()
    val displayDetails = vm.getDisplayDetails()
    //Collect location flow
    val location by vm.location.collectAsStateWithLifecycle()

    //Launch api call once
    LaunchedEffect(Unit) {
        vm.getLocation(record.id.toString(), record.current_location_entry_id.toString())
    }

    //Default Value for cameraPositionState
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(14.6091, 121.0223), 10f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
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
                textColor = ProjectColors.dark_gray
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

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            text = "Current Location:",
            fontSize = 16.sp,
            color = ProjectColors.dark_gray
        )



        //Logic for Handling Location Display
        if (location.isNotEmpty()) {
            //Add lat long from savedStateHandle flow into cameraPositionState
            cameraPositionState.position = CameraPosition.fromLatLngZoom(
                LatLng(
                    location[0].toDouble(),
                    location[1].toDouble()
                ), 10f
            )
            //Stored in a listOf<Int>
            if(location[0] != 0 && location[1] != 0) {
                GoogleMap(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(8.dp),
                    cameraPositionState = cameraPositionState
                ) {
                    Marker(
                        state = MarkerState(
                            position = LatLng(
                                location[0].toDouble(),
                                location[1].toDouble()
                            )
                        )
                    )
                }
            } else {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Location Not Found",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = ProjectColors.red
                )
            }


        }

    }
}