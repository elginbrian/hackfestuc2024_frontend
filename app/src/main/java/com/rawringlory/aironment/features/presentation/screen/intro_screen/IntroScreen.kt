package com.rawringlory.aironment.features.presentation.screen.intro_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rawringlory.aironment.R
import com.rawringlory.aironment.features.presentation.navigation.Screen

@Composable
@Preview
fun IntroScren(
    navController: NavController = rememberNavController()
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF)),
        contentAlignment = Alignment.BottomCenter
    ){
        Image(painter = painterResource(id = R.drawable.greenwave), contentDescription = "green wave", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp, horizontal = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier.size(300.dp)){
                Image(painter = painterResource(id = R.drawable.doll), contentDescription = "doll", modifier = Modifier.fillMaxSize())
            }

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFFFFF)),
                elevation = CardDefaults.cardElevation(1.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                    Text(text = "Halo, Selamat Datang di Aironment!", fontWeight = FontWeight.Medium, fontSize = 23.sp, lineHeight = 32.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Dapatkan informasi kualitas udara & komunitas peduli lingkungan! Bersama, kita bisa buat bumi lebih hijau dan sehat!",
                        lineHeight = 24.sp,
                        color = Color(0xFF929292)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                    ) {
                        Column(modifier = Modifier.fillMaxSize().clickable {
                            navController.navigate(Screen.Login.route)
                        }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Text(text = "Mulai", color = Color.White)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.threedot), contentDescription = "three dot")
        }
    }
}