package com.rawringlory.aironment.features.domain.repository

import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.util.DataWrapper
import kotlinx.coroutines.flow.Flow

interface AirQualityApiRepository{
    suspend fun getCurrentConditionFlow(
        request: GetCurrentConditionRequest
    ): Flow<DataWrapper<GetCurrentConditionResponse>>

    suspend fun getCurrentCondition(
        request: GetCurrentConditionRequest
    ): GetCurrentConditionResponse
}