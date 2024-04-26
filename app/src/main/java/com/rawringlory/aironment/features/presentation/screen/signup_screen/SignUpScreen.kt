package com.rawringlory.aironment.features.presentation.screen.signup_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rawringlory.aironment.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SignUpScreen(){
    Scaffold(
        topBar = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "arrow back")
                Text(text = "Buat Akun", fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.width(16.dp))
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Spacer(modifier = Modifier.padding(32.dp))
                Box(modifier = Modifier.size(120.dp)){
                    Image(painter = painterResource(id = R.drawable.doll), contentDescription = "doll", modifier = Modifier.fillMaxSize())
                }
                Card(modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(36.dp), shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(Color(0xFFD6F3F0))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "Lorem Ipsum", color = Color(0xFF2FB9AD), fontWeight = FontWeight.Medium)
                    }
                }

                Spacer(modifier = Modifier.padding(16.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Nama", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {

                    }
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Email", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {

                    }
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Kata Sandi", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {

                    }
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Konfirmasi Kata Sandi", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {

                    }
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = true, onCheckedChange = {}, colors = CheckboxDefaults.colors(Color(0xFF2FB9AD)))
                    Text(text = "Dengan mendaftar Anda menyetujui Ketentuan & Kebijakan Privasi kami",
                        fontSize = 10.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp), shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                ) {
                    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "Buat Akun", color = Color.White, fontWeight = FontWeight.Medium)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Sudah punya akun?", color = Color(0xFF929292))
                    Text(text = " Masuk", color = Color(0xFF2FB9AD))
                }
            }
        }
    )
}