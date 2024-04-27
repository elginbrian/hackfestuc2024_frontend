package com.rawringlory.aironment.features.domain.repository

import android.content.Context
import android.net.Uri
import com.rawringlory.aironment.features.data.local.TokenEntity
import com.rawringlory.aironment.features.data.remote.auth.request.PostCreateCommunity
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.AirQualityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityDetailsResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetLatLgd
import com.rawringlory.aironment.features.data.remote.auth.response.GetUserCurrentResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostCreateCommunityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import okhttp3.MultipartBody

interface AuthRepository {
    suspend fun PostRegister(request: PostRegisterRequest): PostRegisterResponse
    suspend fun PostLoginRequest(request: PostLoginRequest): PostLoginResponse
    suspend fun GetToken(): TokenEntity
    suspend fun GetUserCurrent(): GetUserCurrentResponse
    suspend fun GetLatLgd(latitude: Double, longitude: Double): GetLatLgd
    suspend fun PostCreateCommunity(postCreateCommunity: PostCreateCommunity, context: Context): PostCreateCommunityResponse
    suspend fun GetAirQuality(latitude: Double, longitude: Double): AirQualityResponse
    suspend fun GetCommunity(): GetCommunityResponse
    suspend fun GetCommunityDetails(id: String): GetCommunityDetailsResponse
}