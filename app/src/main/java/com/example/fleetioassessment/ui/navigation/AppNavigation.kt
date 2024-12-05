package com.example.fleetioassessment.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.fleetioassessment.data.sharedViewModel
import com.example.fleetioassessment.ui.screen.DetailsScreen
import com.example.fleetioassessment.ui.screen.HomeScreen
import com.example.fleetioassessment.viewmodel.VehicleViewModel

@Composable
fun AppNavigation(paddingValues: PaddingValues, onExit: () -> Unit) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.VehicleGraph.route) {

        //Added a Graph within the graph to easily share viewModels
        navigation(
            startDestination = Screen.HomeScreen.route,
            route = Screen.VehicleGraph.route
        ) {
            composable(Screen.HomeScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<VehicleViewModel>(navController)
                HomeScreen(viewModel) {
                    if (it == "close") onExit() else navController.navigate(it)

                }
            }

            composable(Screen.DetailsScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<VehicleViewModel>(navController)
                DetailsScreen(viewModel) {
                    navController.navigate(it)
                }
            }

        }


    }

}