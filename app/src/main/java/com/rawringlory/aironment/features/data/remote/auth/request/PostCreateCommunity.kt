package com.rawringlory.aironment.features.data.remote.auth.request

import android.graphics.Bitmap
import android.net.Uri

data class PostCreateCommunity(
    val name: String,
    val description: String,
    val profilePicture: Bitmap,
    val coverPicture: Bitmap,
    val price: String
)