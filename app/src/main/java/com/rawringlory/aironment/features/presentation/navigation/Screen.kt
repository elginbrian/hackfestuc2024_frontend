package com.rawringlory.aironment.features.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Intro: Screen("intro")
    object Login: Screen("login")
    object SignUp: Screen("signup")
}