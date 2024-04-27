package com.rawringlory.aironment.features.data.remote.airquality_api.response

import com.google.gson.annotations.SerializedName

data class NearestCityDataResponse(
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: NearestCityData
)

data class NearestCityData(
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("location") val location: Location,
    @SerializedName("current") val current: CurrentData
)

data class Location(
    @SerializedName("type") val type: String,
    @SerializedName("coordinates") val coordinates: List<Double>
)

data class CurrentData(
    @SerializedName("pollution") val pollution: PollutionData,
    @SerializedName("weather") val weather: WeatherData
)

data class PollutionData(
    @SerializedName("ts") val ts: String,
    @SerializedName("aqius") val aqius: Int,
    @SerializedName("mainus") val mainus: String,
    @SerializedName("aqicn") val aqicn: Int,
    @SerializedName("maincn") val maincn: String
)

data class WeatherData(
    @SerializedName("ts") val ts: String,
    @SerializedName("tp") val tp: Int,
    @SerializedName("pr") val pr: Int,
    @SerializedName("hu") val hu: Int,
    @SerializedName("ws") val ws: Double,
    @SerializedName("wd") val wd: Int,
    @SerializedName("ic") val ic: String
)