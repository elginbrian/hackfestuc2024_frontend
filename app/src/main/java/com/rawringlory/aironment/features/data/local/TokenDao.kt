package com.rawringlory.aironment.features.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface TokenDao {
    @Upsert
    suspend fun upsertToken(tokenEntity: TokenEntity)

    @Query("SELECT * from token_table")
    suspend fun getToken(): TokenEntity
}