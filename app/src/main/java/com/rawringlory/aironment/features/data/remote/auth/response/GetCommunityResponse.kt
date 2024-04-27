package com.rawringlory.aironment.features.data.remote.auth.response

data class GetCommunityResponse(
    val error: Boolean,
    val message: String,
    val payload: List<Payload6>
)

data class Payload6(
    val id: String,
    val name: String,
    val description: String,
    val profilePicture: String,
    val coverPicture: String
)