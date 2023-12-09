package com.dariwan.appnews.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dariwan.appnews.core.data.source.local.entitiy.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}