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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalRuler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rawringlory.aironment.R
import java.net.SocketAddress

@Composable
@Preview
fun HealthyScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
        ){
        Column(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.healthyscreen), contentDescription = "Healthy Screen",
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
                colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "Udara Sehat", fontWeight = FontWeight.Medium, color = Color.White)
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
            Spacer(modifier = Modifier.height(64.dp))
            Spacer(modifier = Modifier.fillMaxHeight(0.65f))
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(6.dp), shape = RectangleShape) {

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Spacer(modifier = Modifier.fillMaxHeight(0.5f))
            Spacer(modifier = Modifier.height(32.dp))
            Text("Solusi Kesehatan", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = "Untuk kebaikan bersama mari kita laksanakan!", fontSize = 10.sp)

            Spacer(modifier = Modifier.height(24.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color(0xFF2FB9AD))
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text(text = "Yayy kamu bisa keluar dengan bebas!", color = Color(0xFF2FB9AD))
                }
            }
        }
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color = color)
    )
}

private const val DividerAlpha = 0.12f