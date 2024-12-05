package com.example.fleetioassessment.ui.navigation

//This Pattern is easier to implement routes with arguments if needed
sealed class Screen(val route:String) {
    object VehicleGraph:Screen("vehicle_graph")
    object HomeScreen:Screen("home_screen")
    object DetailsScreen:Screen("details_screen")
}