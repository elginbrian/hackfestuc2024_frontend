package com.rawringlory.aironment.features.data.remote.auth.response

data class GetCommunityDetailsResponse(
    val error: Boolean,
    val message: String,
    val payload: Payload7
)

data class Payload7(
    val detail: Detail,
    val members: List<Member>?
)

data class Detail(
    val description: String,
    val gallery: List<String>?
)

data class Member(
    val name: String
)