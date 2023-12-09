package com.dariwan.appnews.presentation.detailnews

import androidx.lifecycle.ViewModel
import com.dariwan.appnews.core.domain.model.News
import com.dariwan.appnews.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailNewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase): ViewModel() {
    fun setBookmarkNews(news: News, newStatus: Boolean) = newsUseCase.setBookmarkNews(news, newStatus)
}