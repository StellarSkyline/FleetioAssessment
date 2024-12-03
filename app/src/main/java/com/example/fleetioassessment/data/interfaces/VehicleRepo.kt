package com.example.fleetioassessment.data.interfaces

import com.example.fleetioassessment.data.VehicleDTO

interface VehicleRepo {

    suspend fun getVehicle():VehicleDTO
}