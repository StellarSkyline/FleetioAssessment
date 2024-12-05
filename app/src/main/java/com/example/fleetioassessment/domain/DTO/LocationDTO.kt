package com.example.fleetioassessment.domain.DTO

data class LocationDTO(
    val address: String? = "",
    val address_components: AddressComponents? = AddressComponents(),
    val contact_id: Any? = Any(),
    val created_at: String? = "",
    val date: String? = "",
    val geolocation: Geolocation? = Geolocation(),
    val id: Int? = 0,
    val is_current: Boolean? = false,
    val item_id: Int? = 0,
    val item_type: String? = "",
    val locatable_id: Int? = 0,
    val locatable_type: String? = "",
    val location: String? = "",
    val updated_at: String? = "",
    val vehicle_id: Int? = 0
)

data class Geolocation(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0
)

data class AddressComponents(
    val city: String? = "",
    val country: String? = "",
    val country_short: String? = "",
    val postal_code: String? = "",
    val region: String? = "",
    val region_short: String? = "",
    val street: String? = "",
    val street_number: String? = ""
)