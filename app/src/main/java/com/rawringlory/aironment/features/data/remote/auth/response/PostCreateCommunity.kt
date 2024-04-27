package com.rawringlory.aironment.features.data.remote.auth.response

data class PostCreateCommunityResponse(
    val error: Boolean,
    val message: String,
    val payload: Payload4
)

data class Payload4(
    val snap_url: String
)