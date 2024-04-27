package com.rawringlory.aironment.features.presentation.screen.charity_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun CharityScreen(){
    val selectedTab = remember {
        mutableStateOf(0)
    }
    Scaffold(
        containerColor = androidx.compose.ui.graphics.Color.LightGray,
        content = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)) {
            }
        },
        bottomBar = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.85f),
                contentAlignment = Alignment.TopCenter
            ){
                Column(modifier = Modifier) {
                    Spacer(modifier = Modifier.padding(32.dp))
                    Card(modifier = Modifier.fillMaxSize(),
                        shape = RectangleShape
                    ) {
                        Scaffold(
                            containerColor = androidx.compose.ui.graphics.Color.White,
                            topBar = {
                                Card(shape = RectangleShape,
                                    colors = CardDefaults.cardColors(androidx.compose.ui.graphics.Color.White)) {
                                    Column(modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, end = 16.dp, start = 16.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Spacer(modifier = Modifier.padding(28.dp))
                                        Text(text = "Komunitas ABC", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                        Spacer(modifier = Modifier.padding(4.dp))
                                        Text(text = "Surabaya, Jawa Timur | 100+ Anggota", fontSize = 12.sp)
                                    }
                                    Spacer(modifier = Modifier.padding(16.dp))
                                    Divider(thickness = 4.dp, color = Color.LightGray)
                                    Spacer(modifier = Modifier.padding(8.dp))
                                    TabRow(selectedTabIndex = selectedTab.value,
                                            contentColor = Color(0xFF2FB9AD),
                                        ){
                                        Tab(selected = selectedTab.value == 0, onClick = { selectedTab.value = 0 }) {
                                            Box(modifier = Modifier.padding(8.dp)){
                                                Text(text = "Tentang", fontWeight = FontWeight.Medium)
                                            }
                                        }
                                        Tab(selected = selectedTab.value == 1, onClick = { selectedTab.value = 1 }) {
                                            Box(modifier = Modifier.padding(8.dp)){
                                                Text(text = "Anggota", fontWeight = FontWeight.Medium)
                                            }
                                        }
                                    }
                                }
                            },
                            content = {
                                LazyColumn(modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)){
                                    item {
                                        Spacer(modifier = Modifier.padding(110.dp))
                                    }
                                    if(selectedTab.value == 0){
                                        item{
                                            Text(text = "Tentang", fontWeight = FontWeight.Medium, fontSize = 18.sp)
                                            Spacer(modifier = Modifier.padding(2.dp))
                                            Text(text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                                fontSize = 15.sp)

                                            Spacer(modifier = Modifier.padding(16.dp))
                                            Text(text = "Galeri", fontWeight = FontWeight.Medium, fontSize = 18.sp)
                                            Spacer(modifier = Modifier.padding(8.dp))
                                            Card(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(110.dp)
                                            ){}
                                        }
                                    } else if(selectedTab.value == 2){
                                        items(10){
                                            CharityFollowerCard()
                                        }
                                    }
                                }
                            },
                            bottomBar = {
                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)){

                                }
                            },
                        )
                    }
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(modifier = Modifier.size(120.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color(0xFF2FB9AD))
                    ){}
                }

            }

        }
    )
}