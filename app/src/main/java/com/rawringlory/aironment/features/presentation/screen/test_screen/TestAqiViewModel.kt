package com.rawringlory.aironment.features.presentation.screen.test_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import com.rawringlory.aironment.features.domain.model.GetCurrentConditionResponse
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestAqiViewModel @Inject constructor(
    private val aqiRepository: AirQualityApiRepository,
    private val authRepository: AuthRepository
): ViewModel() {

    fun signUp(
        request: PostRegisterRequest,
        onFinished: (PostRegisterResponse) -> Unit
    ){
        viewModelScope.launch {
            val result = authRepository.PostRegister(request)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }

    fun login(
        request: PostLoginRequest,
        onFinished: (PostLoginResponse) -> Unit
    ) {
        viewModelScope.launch{
            val result = authRepository.PostLoginRequest(request)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }
}