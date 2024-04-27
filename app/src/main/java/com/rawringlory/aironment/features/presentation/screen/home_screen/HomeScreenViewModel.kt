package com.rawringlory.aironment.features.presentation.screen.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.response.NearestCityDataResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetLatLgd
import com.rawringlory.aironment.features.data.remote.auth.response.GetUserCurrentResponse
import com.rawringlory.aironment.features.data.remote.auth.response.Payload3
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val aqiRepository: AirQualityApiRepository
): ViewModel() {
    fun getToken(
        onFinished: (String) -> Unit
    ){
        var result = ""
        viewModelScope.launch {
            result = authRepository.GetToken().token
        }
        Log.d("vm token", result)
        onFinished(result)
    }

    fun getUserCurrent(
        onFinished: (GetUserCurrentResponse) -> Unit
    ){
        var result = GetUserCurrentResponse(true, "", Payload3("","",""))
        viewModelScope.launch {
            result = authRepository.GetUserCurrent()
        }
        Log.d("vm user", result.toString())
        onFinished(result)
    }

    fun getLatLgd(
        latitude: Double,
        longitude: Double,
        onFinished: (GetLatLgd) -> Unit
    ) {
        viewModelScope.launch {
            val result = authRepository.GetLatLgd(latitude, longitude)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }

    fun getAqi(getCurrentConditionRequest: GetCurrentConditionRequest,
               onFinished: (GetCurrentConditionResponse) -> Unit
               ){
        viewModelScope.launch {
            val result = aqiRepository.getCurrentCondition(getCurrentConditionRequest)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }
    fun getNearestCityData(
        latitude: Double,
        longitude: Double,
        onFinished: (NearestCityDataResponse) -> Unit
    ){
        viewModelScope.launch {
            val result = aqiRepository.getNearestCityData(latitude, longitude)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }
}