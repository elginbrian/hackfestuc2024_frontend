package com.rawringlory.aironment.features.domain.repository

import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.response.NearestCityDataResponse
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse

interface AirQualityApiRepository{
    suspend fun getNearestCityData(
        latitude: Double,
        longitude: Double
    ): NearestCityDataResponse

    suspend fun getCurrentCondition(
        request: GetCurrentConditionRequest
    ): GetCurrentConditionResponse
}