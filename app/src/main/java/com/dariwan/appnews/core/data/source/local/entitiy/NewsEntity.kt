package com.dariwan.appnews.core.data.source.local.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "url")
    val url: String,

    @PrimaryKey
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,

    @ColumnInfo("content")
    val content: String,

    @ColumnInfo(name = "isBookmark")
    var isBookmark: Boolean = false
)