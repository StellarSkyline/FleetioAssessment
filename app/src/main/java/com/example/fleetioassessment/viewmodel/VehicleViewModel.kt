package com.example.fleetioassessment.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fleetioassessment.R
import com.example.fleetioassessment.data.interfaces.VehicleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repo: VehicleRepo,
    app: Application
): ViewModel() {

    init{
        Log.d("STLog", "VM Injected and launched | App Name:${app.getString(R.string.app_name)}")
    }

    fun getVehicle() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("STLog", repo.getVehicle().toString())
        }
    }


}