package com.rawringlory.aironment.features.data.remote.airquality_api

import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.response.GetCurrentConditionDto
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.util.Constant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AirQualityAPI {
    //@Headers("Content-Type: application/json")
    @POST("currentConditions%2Flookup?key=AIzaSyBK-svaulFH2SUe_wktb5Nfev9eHARWzCc")
    suspend fun getCurrentCondition(
        @Header("Content-Type: application/json")
        //@Query("key") apiKey: String = Constant.AQI_API_KEY,
        @Body request: GetCurrentConditionRequest
    ): GetCurrentConditionResponse
}