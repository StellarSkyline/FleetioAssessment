package com.example.fleetioassessment.domain

import retrofit2.Response
import retrofit2.http.GET
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

}