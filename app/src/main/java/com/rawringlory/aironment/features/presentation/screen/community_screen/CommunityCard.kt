package com.rawringlory.aironment.features.presentation.screen.community_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rawringlory.aironment.features.data.remote.auth.response.Payload6

@Composable
//@Preview
fun CommunityCard(payload: Payload6, onTapDetails: (String) -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.White)
        ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.size(72.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                AsyncImage(model = payload.profilePicture, contentDescription = "profile", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp), verticalArrangement = Arrangement.Center) {
                Text(text = payload.name, fontSize = 16.sp, fontWeight = FontWeight.Medium, maxLines = 1)
                Text(text = payload.description, fontSize = 12.sp, lineHeight = 14.sp, maxLines = 2)
                Spacer(modifier = Modifier.padding(4.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(24.dp),
                        colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                        ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = "Gabung", color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .width(100.dp)
                        .height(24.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF2FB9AD))
                    ) {
                        Box(modifier = Modifier.fillMaxSize().clickable{
                                                                       onTapDetails(payload.id)
                        }, contentAlignment = Alignment.Center) {
                            Text(text = "Detail", color = Color(0xFF2FB9AD))
                        }
                    }
                }
            }
        }
    }
    Divider()
}