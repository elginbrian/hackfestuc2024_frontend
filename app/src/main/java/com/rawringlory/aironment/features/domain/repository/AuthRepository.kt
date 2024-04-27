package com.rawringlory.aironment.features.domain.repository

import com.rawringlory.aironment.features.data.local.TokenEntity
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.GetLatLgd
import com.rawringlory.aironment.features.data.remote.auth.response.GetUserCurrentResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse

interface AuthRepository {
    suspend fun PostRegister(request: PostRegisterRequest): PostRegisterResponse
    suspend fun PostLoginRequest(request: PostLoginRequest): PostLoginResponse
    suspend fun GetToken(): TokenEntity
    suspend fun GetUserCurrent(): GetUserCurrentResponse
    suspend fun GetLatLgd(latitude: Double, longitude: Double): GetLatLgd
}