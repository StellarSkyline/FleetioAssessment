package com.example.fleetioassessment.domain

import com.example.fleetioassessment.data.ApiKey
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHelper {
    val vehicleInterceptor = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", "Token ${ApiKey.ApiKey}")
                    .addHeader("Account-Token", ApiKey.AcctKey)
                    .build()
            )
        }
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()

}