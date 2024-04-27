package com.rawringlory.aironment.features.presentation

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rawringlory.aironment.features.presentation.design_system.AironmentTheme
import com.rawringlory.aironment.features.presentation.navigation.Screen
import com.rawringlory.aironment.features.presentation.screen.charity_screen.CharityScreen
import com.rawringlory.aironment.features.presentation.screen.community_screen.CommunityScreen
import com.rawringlory.aironment.features.presentation.screen.detail_screen.DangerScreen
import com.rawringlory.aironment.features.presentation.screen.detail_screen.HealthyScreen
import com.rawringlory.aironment.features.presentation.screen.detail_screen.MidScreen
import com.rawringlory.aironment.features.presentation.screen.home_screen.HomeScreen
import com.rawringlory.aironment.features.presentation.screen.home_screen.HomeScreenViewModel
import com.rawringlory.aironment.features.presentation.screen.intro_screen.IntroScren
import com.rawringlory.aironment.features.presentation.screen.login_screen.LoginScreen
import com.rawringlory.aironment.features.presentation.screen.opendonation_screen.OpenDonationScreen
import com.rawringlory.aironment.features.presentation.screen.signup_screen.SignUpScreen
import com.rawringlory.aironment.features.presentation.screen.volunteer_screen.VolunteerScreen
import com.rawringlory.aironment.features.presentation.widget.systembar.SystemBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AironmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SystemBar()
                    val viewModel = hiltViewModel<HomeScreenViewModel>()
                    var token = remember{ mutableStateOf("") }
                    viewModel.getToken {
                        token.value = it
                    }

                    var currentId = "0"

                    NavHost(navController = navController, startDestination = if(token.value.isNotEmpty()){
                        Screen.Login.route
                    } else {
                        Screen.Home.route
                    }

                    ){
                        composable(Screen.Home.route){
                            HomeScreen(navController)
                        }

                        composable(Screen.Intro.route){
                            IntroScren(navController)
                        }

                        composable(Screen.Login.route){
                            LoginScreen(navController)
                        }

                        composable(Screen.SignUp.route){
                            SignUpScreen(navController)
                        }

                        composable(Screen.Community.route){
                            CommunityScreen(navController){
                                currentId = it
                            }
                        }

                        composable(Screen.Volunteer.route){
                            VolunteerScreen(navController)
                        }

                        composable(Screen.CommunityCreate.route){
                            OpenDonationScreen()
                        }

                        composable(Screen.HealthyScreen.route){
                            HealthyScreen()
                        }

                        composable(Screen.MidScreen.route){
                            MidScreen()
                        }

                        composable(Screen.DangerScreen.route){
                            DangerScreen()
                        }

                        composable(Screen.Charity.route){
                            CharityScreen(id = currentId, navController)
                        }
                    }
                }
            }
        }
    }
}