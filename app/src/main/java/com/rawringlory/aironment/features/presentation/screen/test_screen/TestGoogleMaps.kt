package com.rawringlory.aironment.features.presentation.screen.test_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap

@Composable
fun TestGoogleMaps(){
    Box(modifier = Modifier.fillMaxSize()){
        GoogleMap(modifier = Modifier.fillMaxSize()) {

        }
    }
}