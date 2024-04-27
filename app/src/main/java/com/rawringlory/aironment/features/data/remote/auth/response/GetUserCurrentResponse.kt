package com.rawringlory.aironment.features.data.remote.auth.response

data class GetUserCurrentResponse(
    val error: Boolean,
    val message: String,
    val payload: Payload3
)

data class Payload3(
    val id: String,
    val email: String,
    val full_name: String
)
