package com.rawringlory.aironment.features.presentation.screen.opendonation_screen

import android.R
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rawringlory.aironment.features.data.remote.auth.request.PostCreateCommunity
import com.rawringlory.aironment.features.presentation.screen.volunteer_screen.VolunteerViewModel
import com.rawringlory.aironment.features.presentation.widget.transparent_textfield.TransparentTextField


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun OpenDonationScreen(){
    val context = LocalContext.current
    val viewModel = hiltViewModel<VolunteerViewModel>()
    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    var selectedImageBitmap = remember {
        mutableStateOf(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888))
    }
    val selectedImageBitmap2 = remember {
        mutableStateOf(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888))
    }

    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri ->
        if (uri != null) {
            if (Build.VERSION.SDK_INT < 28) {
                selectedImageBitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                selectedImageBitmap.value = ImageDecoder.decodeBitmap(source)
            }
        }
    }

    val photoPicker2 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
    ) { uri ->
        if (uri != null) {
            if (Build.VERSION.SDK_INT < 28) {
                selectedImageBitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                selectedImageBitmap.value = ImageDecoder.decodeBitmap(source)
            }
        }
    }


    Scaffold(
        topBar = {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = "arrow back", tint= Color.White)
                    Text(text = "Tambah Komunitas", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.padding(50.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Nama", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(20.dp),
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

                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Tentang", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp), shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = description.value, onValueChange = { description.value = it }, onFocusChange = {}, singleLine = false)
                        }
                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Foto Profile", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                photoPicker.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            }
                            .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = selectedImageBitmap.value.toString(), onValueChange = {  }, onFocusChange = {}, singleLine = true)
                        }
                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Foto Sampul", fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp), shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, Color(0xFF929292))
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                            .clickable {
                                photoPicker2.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            }, verticalArrangement = Arrangement.Center){
                            Spacer(modifier = Modifier.padding(4.dp))
                            TransparentTextField(text = selectedImageBitmap2.value.toString(), onValueChange = {  }, onFocusChange = {}, singleLine = true)
                        }
                    }

                    Spacer(modifier = Modifier.padding(40.dp))

                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp), shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(Color(0xFF2FB9AD))
                    ){
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                viewModel.PostCreateCommunity(
                                    request = PostCreateCommunity(
                                        name = name.value,
                                        description = description.value,
                                        coverPicture = selectedImageBitmap.value,
                                        profilePicture = selectedImageBitmap2.value,
                                        price = "69000"
                                    ),
                                    context = context
                                ) {
                                    Log.d("community", it.toString())
                                }
                            },
                            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
                        ){
                            Text(text = "Simpan", color = Color.White, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    )
}