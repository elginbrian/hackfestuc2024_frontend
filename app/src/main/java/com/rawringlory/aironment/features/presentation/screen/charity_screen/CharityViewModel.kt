package com.rawringlory.aironment.features.presentation.screen.charity_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityDetailsResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharityViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    fun getCommunityDetails(id: String, onFinished: (GetCommunityDetailsResponse) -> Unit){
        viewModelScope.launch {
            val result = authRepository.GetCommunityDetails(id)
            Log.d("result", result.toString())
            onFinished(result)
        }
    }
}