package com.rawringlory.aironment.features.data.remote.airquality_api.request

data class GetCurrentConditionRequest(
   val location: Location
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

