package com.rawringlory.aironment.features.data.remote.auth.request

data class PostRegisterRequest(
    val email: String,
    val password: String,
    val full_name: String
)
