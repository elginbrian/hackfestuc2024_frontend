package com.rawringlory.aironment.features.data.remote.auth

import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun PostRegister(@Body request: PostRegisterRequest): PostRegisterResponse

    @POST("auth/login")
    suspend fun PostLogin(@Body request: PostLoginRequest): PostLoginResponse
}