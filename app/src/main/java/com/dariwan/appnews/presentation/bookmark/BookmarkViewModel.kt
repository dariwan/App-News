package com.dariwan.appnews.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dariwan.appnews.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val bookmarkNews = newsUseCase.getBookmarkNews().asLiveData()
}