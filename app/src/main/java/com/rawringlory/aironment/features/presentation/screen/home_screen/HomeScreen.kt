package com.rawringlory.aironment.features.presentation.screen.home_screen

import LatandLong
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddLocation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.rawringlory.aironment.R
import com.rawringlory.aironment.features.data.remote.airquality_api.request.GetCurrentConditionRequest
import com.rawringlory.aironment.features.data.remote.airquality_api.request.Location
import getUserLocation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun HomeScreen(navController: NavController = rememberNavController()){
    val context = LocalContext.current
    var current = remember { mutableStateOf(LatLng(-7.250445,112.768845)) }
    RequestLocationPermission(
        onPermissionGranted = { /*TODO*/ },
        onPermissionDenied = { /*TODO*/ }) {
    }
    getUserLocation(context = context) {
        current.value = it
    }
    
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val currentCoordinate = LatLng(-7.250445,112.768845)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(-7.250445,112.768845), 9f)
    }
    viewModel.getToken {
        Log.d("Token", it)
    }
    viewModel.getUserCurrent {
        Log.d("User", it.toString())
    }

    var LatLgdList = remember {
        mutableStateOf(listOf<com.rawringlory.aironment.features.data.remote.auth.response.Location>(
            com.rawringlory.aironment.features.data.remote.auth.response.Location(0.0,0.0),
            com.rawringlory.aironment.features.data.remote.auth.response.Location(0.0,0.0),
            com.rawringlory.aironment.features.data.remote.auth.response.Location(0.0,0.0)
            ))
    }
    viewModel.getLatLgd(current.value.latitude, current.value.longitude){
        Log.d("LatLgd", it.toString())
        LatLgdList.value = it.payload
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
                cameraPositionState = cameraPositionState,
                uiSettings = MapUiSettings(mapToolbarEnabled = false)
            ) {
                MapMarker(context = context, position = currentCoordinate, title = "Current Position", iconResourceId = R.drawable.greenpin)
                MapMarker(context = context, position = LatLng(LatLgdList.value[0].latitude , LatLgdList.value[0].longitude), title = "around", iconResourceId = R.drawable.yellowpin)
                MapMarker(context = context, position = LatLng(LatLgdList.value[1].latitude, LatLgdList.value[1].longitude), title = "around", iconResourceId = R.drawable.yellowpin)
                MapMarker(context = context, position = LatLng(LatLgdList.value[2].latitude, LatLgdList.value[2].longitude), title = "around", iconResourceId = R.drawable.yellowpin)

        } },
        bottomBar = {
            Text(text = current.value.toString())
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),

            ) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                    colors = CardDefaults.cardColors(Color(0xFFF8F7F7)),
                    shape = RoundedCornerShape(50.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp), horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.size(45.dp)){
                            Image(painter = painterResource(id = R.drawable.udara), contentDescription = "aironment logo", modifier = Modifier.fillMaxSize())
                        }

                        Box(modifier = Modifier.size(45.dp)){
                            Image(painter = painterResource(id = R.drawable.komunitas), contentDescription = "aironment logo", modifier = Modifier.fillMaxSize())
                        }

                        Box(modifier = Modifier.size(45.dp)){
                            Image(painter = painterResource(id = R.drawable.diskusi), contentDescription = "aironment logo", modifier = Modifier.fillMaxSize())
                        }

                        Box(modifier = Modifier.size(45.dp)){
                            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "aironment logo", modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun MapMarker(
    context: Context,
    position: LatLng,
    title: String,
    @DrawableRes iconResourceId: Int
) {
    val icon = bitmapDescriptorFromVector(
        context, iconResourceId
    )
    Marker(
        state = MarkerState(position = position),
        title = title,
        icon = icon,
    )
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}