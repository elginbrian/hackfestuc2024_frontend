package com.rawringlory.aironment.features.data.mapper

import com.rawringlory.aironment.features.data.remote.airquality_api.response.GetCurrentConditionDto
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse

fun GetCurrentConditionDto.toGetCurrentConditionResponse(): GetCurrentConditionResponse{
    return GetCurrentConditionResponse(
        dateTime = dateTime ?: "",
        regionCode = regionCode ?: "",
        indexes  = indexes ?: listOf()
    )
}