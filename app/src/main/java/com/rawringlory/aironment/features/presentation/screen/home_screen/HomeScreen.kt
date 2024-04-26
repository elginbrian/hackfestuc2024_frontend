package com.rawringlory.aironment.features.presentation.screen.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.rawringlory.aironment.features.presentation.navigation.Screen
import com.rawringlory.aironment.features.presentation.screen.test_screen.TestAQI
import com.rawringlory.aironment.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun HomeScreen(navController: NavController = rememberNavController()){
    val surabayaCoordinate = LatLng(-7.24917, 112.75083)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(surabayaCoordinate, 11f)
    }

    Scaffold(
        topBar = {
            Card(
                colors = CardDefaults.cardColors(Color(0xFFF8F7F7)),
                shape = RectangleShape
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(painter = painterResource(id = R.drawable.aironmentlogo), contentDescription = "aironment logo")
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        },
        content = {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {

            }
        },
        bottomBar = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)) {
                Card(modifier = Modifier.fillMaxWidth().height(60.dp),
                    colors = CardDefaults.cardColors(Color(0xFFF8F7F7)),
                    shape = RoundedCornerShape(50.dp)
                    ) {

                }
            }
        }
    )
}