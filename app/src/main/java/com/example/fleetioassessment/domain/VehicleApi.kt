package com.example.fleetioassessment.domain

import com.example.fleetioassessment.domain.DTO.LocationDTO
import com.example.fleetioassessment.domain.DTO.VehicleDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VehicleApi {

    @GET("v1/vehicles")
    suspend fun getVehicles(
        @Query("per_page") maxPage: Int,
        @Query("start_cursor") cursor: String? = null
    ): Response<VehicleDTO>

    @GET("v1/vehicles")
    suspend fun filterVehicles(
        @Query("per_page") maxPage: Int,
        @Query("filter[name][like]") name: String
    ): Response<VehicleDTO>

    @GET("v1/vehicles/{vehicleId}/location_entries/{locationId}")
    suspend fun getLocation(
        @Path("vehicleId") vehicleId: String,
        @Path("locationId") id: String
    ): Response<LocationDTO>

}