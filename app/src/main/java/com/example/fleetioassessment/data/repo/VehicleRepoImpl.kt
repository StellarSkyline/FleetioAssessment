package com.example.fleetioassessment.data.repo

import android.util.Log
import com.example.fleetioassessment.data.VehicleDTO
import com.example.fleetioassessment.data.interfaces.VehicleRepo
import com.example.fleetioassessment.domain.VehicleApi

class VehicleRepoImpl(
    private val api:VehicleApi

): VehicleRepo {
    override suspend fun getVehicle(): VehicleDTO {
        val response = api.getVehicles()

        if(response.isSuccessful) return response.body()!!
        else {
            Log.d("STLog", "Error: ${response.errorBody()}")
            return VehicleDTO()
        }
    }
}