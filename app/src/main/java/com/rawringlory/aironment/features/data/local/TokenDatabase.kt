package com.rawringlory.aironment.features.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TokenEntity::class], version = 1, exportSchema = false)
abstract class TokenDatabase: RoomDatabase() {
    abstract fun TokenDao(): TokenDao
}