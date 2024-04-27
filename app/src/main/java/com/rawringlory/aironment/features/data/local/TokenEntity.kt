package com.rawringlory.aironment.features.data.local

import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey

@DatabaseView
@Entity(tableName = "token_table")
data class TokenEntity(
    @PrimaryKey
    val token: String
)
