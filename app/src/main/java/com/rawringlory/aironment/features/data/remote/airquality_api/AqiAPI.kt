package com.rawringlory.aironment.features.data.remote.airquality_api

import com.rawringlory.aironment.features.data.remote.airquality_api.response.NearestCityDataResponse
import com.rawringlory.aironment.features.util.Constant
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AqiAPI {
    @GET("nearest_city")
    suspend fun getNearestCityData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("key") apiKey: String = Constant.AQI_API_KEY,
    ): NearestCityDataResponse
}