package com.dariwan.appnews.core.data.source.remote.network

import com.dariwan.appnews.BuildConfig
import com.dariwan.appnews.core.data.source.remote.response.ListNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?sources=bbc-news&apiKey=${BuildConfig.API_KEY}")
    suspend fun getAllNews(): ListNewsResponse
}