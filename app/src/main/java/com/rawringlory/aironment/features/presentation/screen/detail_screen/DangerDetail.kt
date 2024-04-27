package com.rawringlory.aironment.features.presentation.screen.detail_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
import com.rawringlory.aironment.R

@Composable
@Preview
fun DangerScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ){
        Column(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.dangerscreen), contentDescription = "Healthy Screen",
                modifier = Modifier.fillMaxWidth())
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Text(text = "Sambi Kerep", fontWeight = FontWeight.Medium, fontSize = 20.sp)
            Text(text = "Surabaya, Jawa Timur", fontWeight = FontWeight.Normal, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Card(modifier = Modifier
                .width(120.dp)
                .height(24.dp),
                colors = CardDefaults.cardColors(Color(0xFFFF5658))
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "Waspada", fontWeight = FontWeight.Medium, color = Color.White)
                }
            }

        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(80.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        Text(text = "34")
                    }
                    VerticalDivider()
                    Column {
                        Text(text = "34")
                    }
                    VerticalDivider()
                    Column {
                        Text(text = "34")
                    }
                }
            }

            Image(painter = painterResource(id = R.drawable.bar), contentDescription = "Bar")
            Spacer(modifier = Modifier.height(32.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(6.dp), shape = RectangleShape
            ) {}
            Spacer(modifier = Modifier.fillMaxHeight(0.65f))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(6.dp), shape = RectangleShape
            ) {}
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ){
            Spacer(modifier = Modifier.padding(4.dp))
            Text("Solusi Kesehatan", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = "Untuk kebaikan bersama mari kita laksanakan!", fontSize = 10.sp)
            Spacer(modifier = Modifier.padding(4.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier.size(72.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                    border = BorderStroke(1.dp, Color(0xFFFF5658))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.water), contentDescription = "Mask")
                    }
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Card(modifier = Modifier.size(72.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                    border = BorderStroke(1.dp, Color(0xFFFF5658))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.friends), contentDescription = "Window")
                    }
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Card(modifier = Modifier.size(72.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                    border = BorderStroke(1.dp, Color(0xFFFF5658))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.purifier), contentDescription = "Bus")
                    }
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Card(modifier = Modifier.size(72.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                    border = BorderStroke(1.dp, Color(0xFFFF5658))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Image(painter = painterResource(id = R.drawable.water2), contentDescription = "Bus")
                    }
                }
            }


            Spacer(modifier = Modifier.height(24.dp))

            Text("Terminal Terdekat", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = "Berikut rekomendasi terminal tersebut", fontSize = 10.sp)

            Spacer(modifier = Modifier.height(24.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                border = BorderStroke(1.dp, Color(0xFFFF5658))
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.CenterStart){
                    Row() {
                        Image(painter = painterResource(id = R.drawable.bus2), contentDescription = "Bus")
                        Spacer(modifier = Modifier.padding(4.dp))
                        Column(
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text(text = "Terminal Joyoboyo", color = Color(0xFFFF5658))
                            Text(text = "Jalan Joyoboyo 60242, Surabaya, Jawa Timur", fontSize = 12.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                border = BorderStroke(1.dp, Color(0xFFFF5658))
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.CenterStart){
                    Row() {
                        Image(painter = painterResource(id = R.drawable.bus2), contentDescription = "Bus")
                        Spacer(modifier = Modifier.padding(4.dp))
                        Column(
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text(text = "Terminal Purabaya", color = Color(0xFFFF5658))
                            Text(text = "Jalan Purabaya 60242, Surabaya, Jawa Timur", fontSize = 12.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
                colors = CardDefaults.cardColors(Color(0xFFFFECEC)),
                border = BorderStroke(1.dp, Color(0xFFFF5658))
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.CenterStart){
                    Row() {
                        Image(painter = painterResource(id = R.drawable.bus2), contentDescription = "Bus")
                        Spacer(modifier = Modifier.padding(4.dp))
                        Column(
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text(text = "Terminal Bojonegoro", color = Color(0xFFFF5658))
                            Text(text = "Jalan Joyoboyo 60242, Surabaya, Jawa Timur", fontSize = 12.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(60.dp))
        }
    }
}