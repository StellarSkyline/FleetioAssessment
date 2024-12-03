package com.example.fleetioassessment.di

import com.example.fleetioassessment.data.BaseValues
import com.example.fleetioassessment.data.interfaces.VehicleRepo
import com.example.fleetioassessment.data.repo.VehicleRepoImpl
import com.example.fleetioassessment.domain.VehicleApi
import com.example.fleetioassessment.domain.NetworkHelper.vehicleInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesVehicleApi(): VehicleApi {
        return Retrofit.Builder()
            .baseUrl(BaseValues.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(vehicleInterceptor)
            .build()
            .create(VehicleApi::class.java)

    }

    @Provides
    @Singleton
    fun providesVehicleRepo(api:VehicleApi):VehicleRepo = VehicleRepoImpl(api)

}