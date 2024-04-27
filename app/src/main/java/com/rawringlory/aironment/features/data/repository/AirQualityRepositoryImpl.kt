package com.rawringlory.aironment.features.data.repository

import android.util.Log
import com.rawringlory.aironment.features.data.remote.airquality_api.AirQualityAPI
import com.rawringlory.aironment.features.data.remote.airquality_api.AqiAPI
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.response.NearestCityDataResponse
import com.rawringlory.aironment.features.data.remote.auth.response.AirQualityResponse
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import javax.inject.Inject

class AirQualityRepositoryImpl @Inject constructor(
    private val aqiAPI: AqiAPI,
    private val airQualityAPI: AirQualityAPI
): AirQualityApiRepository {

    override suspend fun getNearestCityData(
        latitude: Double,
        longitude: Double
    ): NearestCityDataResponse {
        val result = aqiAPI.getNearestCityData(latitude, longitude)
        Log.d("result", result.toString())
        return result
    }

    override suspend fun getCurrentCondition(request: GetCurrentConditionRequest): GetCurrentConditionResponse {
        var result = GetCurrentConditionResponse("","", listOf())
        try {
            result = airQualityAPI.getCurrentCondition(request = request)
        } catch(e: Exception){
            Log.d("air exception", e.toString())
        }
        return result
    }
}