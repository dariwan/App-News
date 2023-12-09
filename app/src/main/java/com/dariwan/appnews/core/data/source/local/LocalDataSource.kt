package com.dariwan.appnews.core.data.source.local

import com.dariwan.appnews.core.data.source.local.entitiy.NewsEntity
import com.dariwan.appnews.core.data.source.local.room.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val newsDao: NewsDao) {

    fun getAllNews(): Flow<List<NewsEntity>> = newsDao.getAllNews()
    fun getBookmarkNews(): Flow<List<NewsEntity>> = newsDao.getBookmarkNews()
    suspend fun insertNews(newsList: List<NewsEntity>) = newsDao.insertNews(newsList)
    fun setBookmarkNews(news: NewsEntity, newState: Boolean){
        news.isBookmark = newState
        newsDao.updateBookmarkNews(news)
    }
}