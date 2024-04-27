package com.rawringlory.aironment.features.data.remote.auth

import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.GetUserCurrentResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/register")
    suspend fun PostRegister(@Body request: PostRegisterRequest): PostRegisterResponse

    @POST("auth/login")
    suspend fun PostLogin(@Body request: PostLoginRequest): PostLoginResponse

    @GET("user/current")
    suspend fun GetUser(@Header("Authorization") bearer: String): GetUserCurrentResponse
}