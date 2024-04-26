package com.rawringlory.aironment.features.presentation.screen.test_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.request.Location

@Composable
fun TestAQI(){
    val viewModel = hiltViewModel<TestAqiViewModel>()
    val request = GetCurrentConditionRequest(
        Location(
            latitude  = 37.419734,
            longitude = -122.0827784
        )
    )
    viewModel.getCurrentCondition(request){
        Log.d("ui", it.toString())
    }
}