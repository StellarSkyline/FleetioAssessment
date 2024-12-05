package com.example.fleetioassessment.data.interfaces

import com.example.fleetioassessment.domain.DTO.LocationDTO
import com.example.fleetioassessment.domain.DTO.VehicleDTO

interface VehicleRepo {
    suspend fun getVehicle(maxPage:Int, cursor:String? = null): VehicleDTO
    suspend fun filterVehicle(name:String): VehicleDTO
    suspend fun getLocation(vehicleId:String,locationId:String): LocationDTO
}