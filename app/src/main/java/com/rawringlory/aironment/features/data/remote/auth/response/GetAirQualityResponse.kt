package com.rawringlory.aironment.features.data.remote.auth.response

import com.google.gson.annotations.SerializedName

data class AirQualityResponse(
    @SerializedName("dateTime") val dateTime: String,
    @SerializedName("regionCode") val regionCode: String,
    @SerializedName("indexes") val indexes: List<Index>
)

data class Index(
    @SerializedName("aqi") val aqi: Int,
    @SerializedName("aqiDisplay") val aqiDisplay: String,
    @SerializedName("category") val category: String,
    @SerializedName("code") val code: String,
    @SerializedName("color") val color: Color,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("dominantPollutant") val dominantPollutant: String
)

data class Color(
    @SerializedName("green") val green: Double,
    @SerializedName("red") val red: Double
)