package com.rawringlory.aironment.features.data.repository

import android.nfc.Tag
import android.util.Log
import com.rawringlory.aironment.features.data.remote.auth.AuthApi
import com.rawringlory.aironment.features.data.remote.auth.request.PostLoginRequest
import com.rawringlory.aironment.features.data.remote.auth.request.PostRegisterRequest
import com.rawringlory.aironment.features.data.remote.auth.response.Payload
import com.rawringlory.aironment.features.data.remote.auth.response.Payload2
import com.rawringlory.aironment.features.data.remote.auth.response.PostLoginResponse
import com.rawringlory.aironment.features.data.remote.auth.response.PostRegisterResponse
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
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
}