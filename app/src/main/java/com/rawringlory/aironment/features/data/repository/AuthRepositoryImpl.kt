package com.rawringlory.aironment.features.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.nfc.Tag
import android.util.Log
import com.rawringlory.aironment.features.data.local.TokenDao
import com.rawringlory.aironment.features.data.local.TokenEntity
import com.rawringlory.aironment.features.data.remote.auth.AuthApi
import com.rawringlory.aironment.features.data.remote.auth.request.PostCreateCommunity
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.AirQualityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.Detail
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityDetailsResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetCommunityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.GetLatLgd
import com.rawringlory.aironment.features.data.remote.auth.response.GetUserCurrentResponse
import com.rawringlory.aironment.features.data.remote.auth.response.Payload
import com.rawringlory.aironment.features.data.remote.auth.response.Payload2
import com.rawringlory.aironment.features.data.remote.auth.response.Payload3
import com.rawringlory.aironment.features.data.remote.auth.response.Payload6
import com.rawringlory.aironment.features.data.remote.auth.response.Payload7
import com.rawringlory.aironment.features.data.remote.auth.response.PostCreateCommunityResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val tokenDao: TokenDao
): AuthRepository {
    override suspend fun PostLoginRequest(request: PostLoginRequest): PostLoginResponse {
        var response = PostLoginResponse(
            error = true,
            message = "Email atau password salah.",
            payload = Payload2("", "")
        )
        try {
            response = withContext(Dispatchers.IO) {
                async { authApi.PostLogin(request) }
            }.await()

        } catch (e: Exception) {
            Log.d("", e.message.toString())
            response.message = e.message.toString()
        }
        Log.d("Login", response.toString())

        tokenDao.upsertToken(TokenEntity(response.payload.token))
        return response
    }

    override suspend fun PostRegister(request: PostRegisterRequest): PostRegisterResponse {
        var response = PostRegisterResponse(error = true, message = "Email atau password salah.", payload = Payload(""))
        try {
            response = withContext(Dispatchers.IO) {
                async { authApi.PostRegister(request) }
            }.await()
        } catch(e: Exception){
            Log.d("", e.message.toString())
            response.message = e.message.toString()
        }

        Log.d("Register", response.toString())
        return response
    }

    override suspend fun GetToken(): TokenEntity {
        val result = tokenDao.getToken()
        Log.d("get token", result.token)
        return result
    }

    override suspend fun GetUserCurrent(): GetUserCurrentResponse {
        var result = GetUserCurrentResponse(error = true, message = "error", Payload3("","",""))
        try {
            result = withContext(Dispatchers.IO) {
                async { authApi.GetUser("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemF0aW9uIjp0cnVlLCJlbWFpbCI6ImVsZ2luYnJpYW40OUBnbWFpbC5jb20iLCJleHAiOjE3MTQyNTYyMzAsImlkIjoiOGM3MWE3OWYtZDgyYS00N2FhLWEzM2UtNWRmNGU5NzgzZDAxIn0.bYEF4k_16LsVVh8Ws_Je_t6H8KRv37_3pk9dEfancSU") }
            }.await()
            Log.d("get user", result.toString())
        } catch (e: Exception){
            Log.d("get user", e.message.toString())
        }

        return result
    }

    override suspend fun GetLatLgd(latitude: Double, longitude: Double): GetLatLgd {
        val bearer = withContext(Dispatchers.IO) {
            async { tokenDao.getToken().token }
        }.await()
        val result = authApi.GetLatLgd(latitude, longitude)
        return result
    }

    override suspend fun PostCreateCommunity(postCreateCommunity: PostCreateCommunity, context: Context): PostCreateCommunityResponse {
        val stream = ByteArrayOutputStream()
        postCreateCommunity.profilePicture.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()
        val profilePictureRequestBody = MultipartBody.Part.createFormData("profilePicture", "photo", byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, byteArray.size))

        val stream2 = ByteArrayOutputStream()
        postCreateCommunity.coverPicture.compress(Bitmap.CompressFormat.JPEG, 80, stream2)
        val byteArray2 = stream2.toByteArray()
        val coverPictureRequestBody = MultipartBody.Part.createFormData("coverPicture", "photo", byteArray2.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, byteArray2.size))

        // Other form fields
        val nameRequestBody = postCreateCommunity.name.toRequestBody("text/plain".toMediaTypeOrNull())
        val descriptionRequestBody = postCreateCommunity.description.toRequestBody("text/plain".toMediaTypeOrNull())
        val priceRequestBody = postCreateCommunity.price.toRequestBody("text/plain".toMediaTypeOrNull())

        val bearer = withContext(Dispatchers.IO) {
            async { tokenDao.getToken().token }
        }.await()

        return withContext(Dispatchers.IO) {
            authApi.CreateCommunity(
                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemF0aW9uIjp0cnVlLCJlbWFpbCI6ImVsZ2luYnJpYW40OUBnbWFpbC5jb20iLCJleHAiOjE3MTQyNTYyMzAsImlkIjoiOGM3MWE3OWYtZDgyYS00N2FhLWEzM2UtNWRmNGU5NzgzZDAxIn0.bYEF4k_16LsVVh8Ws_Je_t6H8KRv37_3pk9dEfancSU",
                nameRequestBody,
                descriptionRequestBody,
                profilePictureRequestBody,
                coverPictureRequestBody,
                priceRequestBody
            )
        }
    }

    override suspend fun GetAirQuality(latitude: Double, longitude: Double): AirQualityResponse {
        var result = AirQualityResponse("","", listOf())
        try {
            result = withContext(Dispatchers.IO) {
                async { authApi.GetAirQuality(latitude, longitude) }
            }.await()
            Log.d("Air quality", result.toString())
        } catch (e: Exception){
            Log.d("Air quality", e.toString())
        }
        return result
    }

    override suspend fun GetCommunity(): GetCommunityResponse {
        var result = GetCommunityResponse(true, "", listOf())
        try {
            result = authApi.GetCommunity("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemF0aW9uIjp0cnVlLCJlbWFpbCI6ImVsZ2luYnJpYW40OUBnbWFpbC5jb20iLCJleHAiOjE3MTQyNTYyMzAsImlkIjoiOGM3MWE3OWYtZDgyYS00N2FhLWEzM2UtNWRmNGU5NzgzZDAxIn0.bYEF4k_16LsVVh8Ws_Je_t6H8KRv37_3pk9dEfancSU")
        } catch (e: Exception){
            Log.d("Get community", e.toString())
        }
        return result
    }

    override suspend fun GetCommunityDetails(id: String): GetCommunityDetailsResponse {
       var result = GetCommunityDetailsResponse(error = true, message = "", payload = Payload7(
           Detail("", listOf()), listOf()
       ))
        try {
             result = withContext(Dispatchers.IO) {
                authApi.GetCommunityDetails(
                    bearer = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemF0aW9uIjp0cnVlLCJlbWFpbCI6ImVsZ2luYnJpYW40OUBnbWFpbC5jb20iLCJleHAiOjE3MTQyNTYyMzAsImlkIjoiOGM3MWE3OWYtZDgyYS00N2FhLWEzM2UtNWRmNGU5NzgzZDAxIn0.bYEF4k_16LsVVh8Ws_Je_t6H8KRv37_3pk9dEfancSU",
                    id = id)
             }
        } catch (e: Exception){
            Log.d("Get community details", e.toString())
        }

        return result
    }
}