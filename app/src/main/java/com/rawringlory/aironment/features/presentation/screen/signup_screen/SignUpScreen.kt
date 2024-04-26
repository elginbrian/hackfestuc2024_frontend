package com.rawringlory.aironment.features.presentation.screen.signup_screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rawringlory.aironment.R
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.presentation.navigation.Screen
import com.rawringlory.aironment.features.presentation.widget.transparent_textfield.TransparentTextField
import okhttp3.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun SignUpScreen(
    navController: NavController = rememberNavController()
){
    val viewModel       = hiltViewModel<SignInViewModel>()
    val context         = LocalContext.current
    val name            = remember { mutableStateOf("") }
    val email           = remember { mutableStateOf("") }
    val password        = remember { mutableStateOf("") }
    val passwordConfirm = remember { mutableStateOf("") }
    val check           = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Card(
                colors = CardDefaults.cardColors(Color(0xFFF8F7F7))
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "arrow back", modifier = Modifier.clickable {
                        navController.navigate(Screen.Login.route)
                    })
                    Text(text = "Buat Akun", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,

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
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = name.value, onValueChange = { name.value = it }, onFocusChange = {}, singleLine = true)
                        }
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
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = email.value, onValueChange = { email.value = it }, onFocusChange = {}, singleLine = true)
                        }
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
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = password.value, onValueChange = { password.value = it }, onFocusChange = {}, singleLine = true)
                        }
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
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = passwordConfirm.value, onValueChange = { passwordConfirm.value = it}, onFocusChange = {}, singleLine = true)
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(4.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = check.value, onCheckedChange = { check.value = !check.value }, colors = CheckboxDefaults.colors(Color(0xFF2FB9AD)))
                    Text(text = "Dengan mendaftar Anda menyetujui Ketentuan & Kebijakan Privasi kami",
                        fontSize = 10.sp, lineHeight = 14.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp), shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            if(name.value.isNotEmpty() && email.value.contains("@gmail.com") && password.value.length >= 6){
                                viewModel.signUp(PostRegisterRequest(email.value, password.value, name.value)){
                                    if (!it.error) {
                                        navController.navigate(Screen.Login.route)
                                        Toast
                                            .makeText(context, it.message, Toast.LENGTH_LONG)
                                            .show()
                                    } else {
                                        Toast
                                            .makeText(context, it.message, Toast.LENGTH_LONG)
                                            .show()
                                    }
                                }
                            } else if (name.value.isEmpty()){
                                Toast.makeText(context, "Nama tidak boleh kosong.", Toast.LENGTH_LONG).show()
                            } else if (!email.value.contains("@gmail.com")){
                                Toast.makeText(context, "Masukkan email yang valid.", Toast.LENGTH_LONG).show()
                            } else if (password.value.length < 6){
                                Toast.makeText(context, "Password minimal terdiri dari 6 karakter", Toast.LENGTH_LONG).show()
                            }
                        }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Text(text = "Buat Akun", color = Color.White, fontWeight = FontWeight.Medium)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Sudah punya akun?", color = Color(0xFF929292))
                    Text(text = " Masuk", color = Color(0xFF2FB9AD), modifier = Modifier.clickable {
                        navController.navigate(Screen.Login.route)
                    })
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}