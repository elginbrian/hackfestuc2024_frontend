package com.rawringlory.aironment.features.presentation.screen.volunteer_screen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rawringlory.aironment.R

@Composable
@Preview
fun VolunteerScreen(){
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
                    .clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ){

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
                    .clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                ){

                }
            }
        }
    }
}