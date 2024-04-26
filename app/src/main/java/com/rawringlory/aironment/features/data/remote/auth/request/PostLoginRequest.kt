package com.rawringlory.aironment.features.data.remote.auth.request

data class PostLoginRequest(
    var email: String,
    var password: String
)