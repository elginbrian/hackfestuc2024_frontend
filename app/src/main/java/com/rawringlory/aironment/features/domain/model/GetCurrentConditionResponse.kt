package com.rawringlory.aironment.features.domain.model

import com.google.gson.annotations.SerializedName
import com.rawringlory.aironment.features.data.remote.airquality_api.response.AirQualityIndex

data class GetCurrentConditionResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<AirQualityIndex>
)