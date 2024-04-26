package com.rawringlory.aironment.features.presentation.screen.test_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.util.DataWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestAqiViewModel @Inject constructor(
    private val repository: AirQualityApiRepository
): ViewModel() {
    fun getCurrentCondition(
        request: GetCurrentConditionRequest,
        onFinished: (GetCurrentConditionResponse) -> Unit
    ){
        viewModelScope.launch {
            val result = repository.getCurrentCondition(request)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }

}