package com.dariwan.appnews.core.domain.usecase

import com.dariwan.appnews.core.data.Resource
import com.dariwan.appnews.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getAllNews(): Flow<Resource<List<News>>>
    fun getBookmarkNews(): Flow<List<News>>
    fun setBookmarkNews(news: News, state: Boolean)
}