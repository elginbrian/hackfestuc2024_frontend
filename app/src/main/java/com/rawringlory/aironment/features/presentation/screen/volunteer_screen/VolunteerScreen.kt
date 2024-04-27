package com.rawringlory.aironment.features.presentation.screen.volunteer_screen

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rawringlory.aironment.R
import com.rawringlory.aironment.features.data.remote.auth.request.PostCreateCommunity
import com.rawringlory.aironment.features.presentation.navigation.Screen

@Composable
@Preview
fun VolunteerScreen(
    navController: NavController = rememberNavController()
){
    val viewModel = hiltViewModel<VolunteerViewModel>()

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri.value = uri }
    )

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.volunteer), contentDescription = "volunteer_background", modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Bottom) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(44.dp), shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
            ){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(Screen.CommunityCreate.route)
                    },
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Lanjutkan", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(44.dp), shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(Color.Transparent),
                border = BorderStroke(2.dp, Color(0xFF2FB9AD))
            ){
                Column(modifier = Modifier
                    .fillMaxSize()
                    .clickable {

                    },
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Kembali", color = Color(0xFF2FB9AD), fontWeight = FontWeight.Medium)
                }
            }
            Spacer(modifier = Modifier.padding(40.dp))
        }
    }
}