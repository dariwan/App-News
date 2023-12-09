package com.dariwan.appnews.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class NewsResponse (

    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("urlToImage")
    val urlToImage: String,

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("content")
    val content: String,
)