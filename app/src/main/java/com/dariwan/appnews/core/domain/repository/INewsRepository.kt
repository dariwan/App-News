package com.dariwan.appnews.core.domain.repository

import com.dariwan.appnews.core.data.Resource
import com.dariwan.appnews.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface INewsRepository {
    fun getAllNews(): Flow<Resource<List<News>>>
    fun getBookmarkNews(): Flow<List<News>>
    fun setBookmarkNews(news: News, state: Boolean)
}