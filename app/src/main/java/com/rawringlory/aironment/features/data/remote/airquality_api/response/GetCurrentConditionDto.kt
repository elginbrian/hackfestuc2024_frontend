package com.rawringlory.aironment.features.data.remote.airquality_api.response

import com.google.gson.annotations.SerializedName
data class GetCurrentConditionDto(
    @SerializedName("dateTime") val dateTime: String?,
    @SerializedName("regionCode") val regionCode: String?,
    @SerializedName("indexes") val indexes: List<AirQualityIndex>?
)

data class AirQualityIndex(
    @SerializedName("code") val code: String?,
    @SerializedName("displayName") val displayName: String?,
    @SerializedName("aqi") val aqi: Int?,
    @SerializedName("aqiDisplay") val aqiDisplay: String?,
    @SerializedName("color") val color: Color?,
    @SerializedName("category") val category: String?,
    @SerializedName("dominantPollutant") val dominantPollutant: String?
)

data class Color(
    @SerializedName("red") val red: Double?,
    @SerializedName("green") val green: Double?,
    @SerializedName("blue") val blue: Double?
)