package com.dariwan.appnews.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListNewsResponse (
@SerializedName("status")
val status: String,

@SerializedName("articles")
val articles: List<NewsResponse>
)