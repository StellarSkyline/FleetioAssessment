package com.example.fleetioassessment.data.interfaces

import com.example.fleetioassessment.domain.VehicleDTO

interface VehicleRepo {
    suspend fun getVehicle(maxPage:Int, cursor:String? = null): VehicleDTO
    suspend fun filterVehicle(name:String): VehicleDTO
}