package com.rawringlory.aironment.features.data.remote.airquality_api

import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.response.GetCurrentConditionDto
import com.rawringlory.aironment.features.util.Constant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AirQualityAPI {
    @Headers("Content-Type: application/json")
    @POST("/v1/currentConditions:lookup?key=AIzaSyBXriY9Lm3hmD3R8BA110CaDYD5q0tec44s")
    suspend fun getCurrentCondition(
        //@Header("Authorization") apiKey: String = Constant.AQI_API_KEY,
        @Body request: GetCurrentConditionRequest
    ): GetCurrentConditionDto
}