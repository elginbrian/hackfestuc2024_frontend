package com.rawringlory.aironment.features.data.remote.auth.response

import java.time.OffsetDateTime

data class PostLoginResponse(
    val error: Boolean,
    var message: String,
    val payload: Payload2
)

data class Payload2(
    val token: String,
    val expire_at: String
)