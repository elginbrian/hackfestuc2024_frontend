package com.rawringlory.aironment.features.data.remote.auth.response

data class GetLatLgd(
    val error: Boolean,
    val message: String,
    val payload: List<Location>
)

data class Location(
    val latitude: Double,
    val longitude: Double
)
