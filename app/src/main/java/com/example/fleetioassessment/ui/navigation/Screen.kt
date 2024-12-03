package com.example.fleetioassessment.ui.navigation

sealed class Screen(val route:String) {
    object VehicleGraph:Screen("vehicle_graph")
    object HomeScreen:Screen("home_screen")


}