package com.rawringlory.aironment.di

import android.content.Context
import androidx.room.Room
import com.rawringlory.aironment.features.data.local.TokenDao
import com.rawringlory.aironment.features.data.local.TokenDatabase
import com.rawringlory.aironment.features.data.remote.airquality_api.AirQualityAPI
import com.rawringlory.aironment.features.data.remote.airquality_api.AqiAPI
import com.rawringlory.aironment.features.data.remote.auth.AuthApi
import com.rawringlory.aironment.features.data.repository.AirQualityRepositoryImpl
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.util.Constant
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAirQualityApi(): AirQualityAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.AQI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AirQualityAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideAqiAPI(): AqiAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.AQI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AqiAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl(Constant.AUTH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenDatabase(@ApplicationContext context: Context): TokenDatabase =
        Room.databaseBuilder(context, TokenDatabase::class.java, "token_db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTokenDAO(TokenDatabase: TokenDatabase): TokenDao = TokenDatabase.TokenDao()
}