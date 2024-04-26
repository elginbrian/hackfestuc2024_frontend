package com.rawringlory.aironment.features.presentation.screen.login_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
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