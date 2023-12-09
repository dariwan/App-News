package com.dariwan.appnews.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dariwan.appnews.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val news = newsUseCase.getAllNews().asLiveData()
}