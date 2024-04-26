package com.rawringlory.aironment.features.data.remote.auth.response

data class PostRegisterResponse(
    val error: Boolean,
    var message: String,
    val payload: Payload
)

data class Payload(
    val id: String
)