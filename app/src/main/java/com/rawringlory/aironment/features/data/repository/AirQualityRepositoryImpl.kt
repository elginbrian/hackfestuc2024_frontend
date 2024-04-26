package com.rawringlory.aironment.features.data.repository

import android.util.Log
import com.rawringlory.aironment.features.data.mapper.toGetCurrentConditionResponse
import com.rawringlory.aironment.features.data.remote.airquality_api.AirQualityAPI
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.util.DataWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AirQualityRepositoryImpl @Inject constructor(
    private val airQualityAPI: AirQualityAPI
): AirQualityApiRepository {
    override suspend fun getCurrentConditionFlow(request: GetCurrentConditionRequest): Flow<DataWrapper<GetCurrentConditionResponse>> {
        return flow {
            emit(DataWrapper.Loading(true))
            val result = airQualityAPI.getCurrentCondition(request = request)
            if(result.regionCode?.isNotEmpty() == true){
                Log.d("getCurrentCondition", result.toString())
                emit(DataWrapper.Success(
                    data = result.toGetCurrentConditionResponse()
                ))
                emit(DataWrapper.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getCurrentCondition(request: GetCurrentConditionRequest): GetCurrentConditionResponse {
        return airQualityAPI.getCurrentCondition(request = request).toGetCurrentConditionResponse()
    }
}