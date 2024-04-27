package com.rawringlory.aironment.features.presentation.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Intro: Screen("intro")
    object Login: Screen("login")
    object SignUp: Screen("signup")
    object Community: Screen("community")
    object Volunteer: Screen("volunteer")
    object CommunityCreate: Screen("community-create")
    object HealthyScreen: Screen("healthy")
    object MidScreen: Screen("mid")
    object DangerScreen: Screen("danger")
    object Charity: Screen("charity")
}