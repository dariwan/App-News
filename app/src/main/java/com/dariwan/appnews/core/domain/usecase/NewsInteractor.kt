package com.dariwan.appnews.core.domain.usecase

import com.dariwan.appnews.core.data.Resource
import com.dariwan.appnews.core.data.source.NewsRepository
import com.dariwan.appnews.core.domain.model.News
import com.dariwan.appnews.core.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository): NewsUseCase {
    override fun getAllNews(): Flow<Resource<List<News>>> = newsRepository.getAllNews()
    override fun getBookmarkNews(): Flow<List<News>> = newsRepository.getBookmarkNews()
    override fun setBookmarkNews(news: News, state: Boolean) = newsRepository.setBookmarkNews(news, state)
}