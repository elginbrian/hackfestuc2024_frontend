package com.rawringlory.aironment.features.presentation.screen.charity_screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
@Preview
fun CharityFollowerCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(110.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.size(72.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = CircleShape
            ) {
                AsyncImage(model = "", contentDescription = "")
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp), verticalArrangement = Arrangement.Center) {
                Text(text = "Username ABC", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
    Divider()
}