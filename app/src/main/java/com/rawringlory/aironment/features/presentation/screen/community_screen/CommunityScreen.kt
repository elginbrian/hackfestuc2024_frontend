package com.rawringlory.aironment.features.presentation.screen.community_screen

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
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
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.rawringlory.aironment.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun CommunityScreen(){
    Scaffold(
        topBar = {
                 Card(modifier = Modifier
                     .fillMaxWidth()
                     .height(120.dp),
                        shape = RectangleShape,
                        colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                 ) {
                     Column(
                         modifier = Modifier
                             .padding(16.dp)
                             .fillMaxSize(),
                         verticalArrangement = Arrangement.Center,
                     ) {
                         Text(text = "Apa kabar, Surabaya", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                         Spacer(modifier = Modifier.padding(4.dp))
                         Text(text = "Lorem ipsum dot amet lalala", color = Color.White, fontSize = 12.sp)
                     }
                 }
        },
        content = {
                  LazyColumn(modifier = Modifier
                      .fillMaxSize()
                      .padding(top = 120.dp)){
                    items(10){
                        CommunityCard()
                    }
                  }
        },
        bottomBar = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)) {
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
        }, floatingActionButton = {
            Card(modifier = Modifier.size(60.dp),
                colors = CardDefaults.cardColors(Color(0xFF2FB9AD)),
                shape = CircleShape,
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.Add, "add", tint = Color.White)
                }
            }
        }
    )
}