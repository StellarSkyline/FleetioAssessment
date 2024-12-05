package com.example.fleetioassessment.data.repo

import android.util.Log
import com.example.fleetioassessment.domain.DTO.VehicleDTO
import com.example.fleetioassessment.data.interfaces.VehicleRepo
import com.example.fleetioassessment.domain.DTO.LocationDTO
import com.example.fleetioassessment.domain.VehicleApi

class VehicleRepoImpl(
    private val api:VehicleApi

): VehicleRepo {
    override suspend fun getVehicle(maxPage: Int, cursor: String?): VehicleDTO {
        val response = api.getVehicles(maxPage, cursor)

        if(response.isSuccessful) return response.body()!!
        else {
            Log.d("STLog", "Error: ${response.errorBody()}")
            return VehicleDTO()
        }
    }

    override suspend fun filterVehicle(name: String): VehicleDTO {
        val response = api.filterVehicles(6,name)

        if(response.isSuccessful) return response.body()!!
        else {
            Log.d("STLog", "Error: ${response.errorBody()}")
            return VehicleDTO()
        }
    }

    override suspend fun getLocation(vehicleId: String, locationId: String): LocationDTO {
        val response = api.getLocation(vehicleId, locationId)

        if(response.isSuccessful) return response.body()!!
        else {
            Log.d("STLog", "Error: ${response.errorBody()}")
            return LocationDTO()
        }
    }
}