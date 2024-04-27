package com.rawringlory.aironment.features.data.remote.auth

import android.telecom.Call
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
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthApi {
    @POST("auth/register")
    suspend fun PostRegister(@Body request: PostRegisterRequest): PostRegisterResponse

    @POST("auth/login")
    suspend fun PostLogin(@Body request: PostLoginRequest): PostLoginResponse

    @GET("user/current")
    suspend fun GetUser(@Header("Authorization") bearer: String): GetUserCurrentResponse

    @GET("user/airqualitys")
    suspend fun GetLatLgd(
        //@Header("Authorization") bearer: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): GetLatLgd

    @Multipart
    @POST("community")
    suspend fun CreateCommunity(
        @Header("Authorization") bearer: String,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part profilePicture: MultipartBody.Part,
        @Part coverPicture: MultipartBody.Part,
        @Part("price") price: RequestBody
    ): PostCreateCommunityResponse

    @GET("airquality")
    suspend fun GetAirQuality(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ): AirQualityResponse

    @GET("community")
    suspend fun GetCommunity(
        @Header("Authorization") bearer: String
    ): GetCommunityResponse

    @GET("community/{id}")
    suspend fun GetCommunityDetails(
        @Header("Authorization") bearer: String,
        @Path("id") id: String
    ):GetCommunityDetailsResponse
}