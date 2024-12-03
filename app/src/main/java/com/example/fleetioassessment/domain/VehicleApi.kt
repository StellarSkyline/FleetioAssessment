package com.example.fleetioassessment.domain

import com.example.fleetioassessment.data.VehicleDTO
import retrofit2.Response
import retrofit2.http.GET

interface VehicleApi {
    @GET("v1/vehicles")
    suspend fun getVehicles(): Response<VehicleDTO>
}