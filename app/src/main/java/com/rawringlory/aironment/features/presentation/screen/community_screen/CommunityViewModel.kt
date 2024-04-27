package com.rawringlory.aironment.features.presentation.screen.community_screen

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    fun getCommunity(
        onFinished: (GetCommunityResponse) -> Unit
    ) {
        viewModelScope.launch {
            val result = authRepository.GetCommunity()
            Log.d("community", result.toString())
            onFinished(result)
        }
    }
}