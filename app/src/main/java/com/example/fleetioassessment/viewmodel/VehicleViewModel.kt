package com.example.fleetioassessment.viewmodel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fleetioassessment.domain.DTO.Record
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
) : ViewModel() {

    val cursor = savedStateHandle.getStateFlow("cursor", "")
    val records = savedStateHandle.getStateFlow("records", listOf<Record>())
    val searchText = savedStateHandle.getStateFlow("searchText", "")
    val location = savedStateHandle.getStateFlow("location", listOf<Int>())
    private var savedRecord = Record()

    //User clicked record Handler
    fun getRecord(): Record = savedRecord
    fun setRecord(record: Record) {
        savedRecord = record
    }

    fun onChangeState(searchText:String) {
        savedStateHandle["searchText"] = searchText
    }

    fun getVehicle(cursor: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            val maxPages = 6
            if(cursor.isNullOrEmpty()) {
                val response = repo.getVehicle(maxPages)
                savedStateHandle["cursor"] = response.next_cursor
                savedStateHandle["records"] = response.records
            } else {
                val response = repo.getVehicle(maxPages, cursor)
                savedStateHandle["cursor"] = response.next_cursor
                savedStateHandle["records"] = response.records
            }
        }
    }

    fun filterVehicle(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if(records.value.isNotEmpty()) {
                savedStateHandle["records"] = listOf<Record>()
                val response = repo.filterVehicle(name)
                savedStateHandle["records"] = response.records
            } else {
                val response = repo.filterVehicle(name)
                savedStateHandle["records"] = response.records
            }
        }
    }

    fun getDisplayDetails(): List<Pair<String, String>> {
        val displayDetails = mutableListOf<Pair<String, String>>()
        displayDetails.add(Pair("Name:", savedRecord.name ?: "N/A"))
        displayDetails.add(Pair("Make:", savedRecord.make ?: "N/A"))
        displayDetails.add(Pair("Model:", savedRecord.model ?: "N/A"))
        displayDetails.add(Pair("VIN:", savedRecord.vin ?: "N/A"))
        displayDetails.add(Pair("License Plate:", savedRecord.license_plate ?: "N/A"))
        displayDetails.add(Pair("Primary Meter:", savedRecord.primary_meter_value ?: "N/A"))
        displayDetails.add(Pair("Secondary Meter:", savedRecord.secondary_meter_value ?: "N/A"))
        return displayDetails
    }

    fun getLocation(vehicleId: String, locationId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getLocation(vehicleId, locationId)
            savedStateHandle["location"] = listOf(response.geolocation?.latitude, response.geolocation?.longitude)

        }

    }
}