package com.rawringlory.aironment.features.presentation.screen.login_screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rawringlory.aironment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun LoginScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Image(painter = painterResource(id = R.drawable.loginbackground), contentDescription = "background",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.55f)
            .padding(32.dp),
        ) {
            Text(text = "Login", fontWeight = FontWeight.Medium, color = Color(0xFF2FB9AD), fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "",
                onValueChange = {  },
                label = { Text("Email") },
                colors = TextFieldDefaults.textFieldColors(Color.White),
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = "",
                onValueChange = {  },
                label = { Text("Kata Sandi") },
                colors = TextFieldDefaults.textFieldColors(Color.White),
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(44.dp), shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
            ) {
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Text(text = "Masuk", color = Color.White, fontWeight = FontWeight.Medium)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Belum punya akun", color = Color(0xFF929292))
                Text(text = " Daftar", color = Color(0xFF2FB9AD))
            }

        }
    }
}