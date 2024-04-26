package com.rawringlory.aironment.features.presentation.widget.systembar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SystemBar(){
    val systemUIController = rememberSystemUiController()
    val darkMode = isSystemInDarkTheme()
    SideEffect {
        systemUIController.setSystemBarsColor(
            color = Color(0xFF2FB9AD),
            darkIcons = false
        )
    }
}