package com.example.fleetioassessment.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fleetioassessment.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    app: Application
): ViewModel() {

    init{
        Log.d("STLog", "VM Injected and launched | App Name:${app.getString(R.string.app_name)}")

    }


}