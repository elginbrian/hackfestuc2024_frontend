package com.rawringlory.aironment.features.presentation.screen.volunteer_screen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawringlory.aironment.features.data.remote.auth.request.PostCreateCommunity
import com.rawringlory.aironment.features.data.remote.auth.response.PostCreateCommunityResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VolunteerViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel(){

    fun PostCreateCommunity(
        request: PostCreateCommunity,
        context: Context,
        onFinished: (PostCreateCommunityResponse) -> Unit
    ){
        viewModelScope.launch {
            val result = authRepository.PostCreateCommunity(request, context)
            Log.d("create community", result.toString())
            onFinished(result)
        }
    }
}