package com.example.fleetioassessment.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.fleetioassessment.data.sharedViewModel
import com.example.fleetioassessment.ui.screen.HomeScreen
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.VehicleGraph.route) {

        navigation(
            startDestination = Screen.HomeScreen.route,
            route = Screen.VehicleGraph.route
        ) {
            composable(Screen.HomeScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<VehicleViewModel>(navController)
                HomeScreen(viewModel) {
                    //handle navigation
                }
            }

        }



    }

}