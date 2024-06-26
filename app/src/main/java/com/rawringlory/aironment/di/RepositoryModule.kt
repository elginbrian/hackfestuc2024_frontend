package com.rawringlory.aironment.di

import com.rawringlory.aironment.features.data.repository.AirQualityRepositoryImpl
import com.rawringlory.aironment.features.data.repository.AuthRepositoryImpl
import com.rawringlory.aironment.features.domain.repository.AirQualityApiRepository
import com.rawringlory.aironment.features.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAirQualityApiRepository(
        airQualityApiRepositoryImpl: AirQualityRepositoryImpl
    ): AirQualityApiRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}