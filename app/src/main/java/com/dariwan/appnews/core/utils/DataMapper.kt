package com.dariwan.appnews.core.utils

import com.dariwan.appnews.core.data.source.local.entitiy.NewsEntity
import com.dariwan.appnews.core.data.source.remote.response.NewsResponse
import com.dariwan.appnews.core.domain.model.News
import java.util.ArrayList

object DataMapper {
    fun mapResponseToEntities(input: List<NewsResponse>): List<NewsEntity>{
        val newsList = ArrayList<NewsEntity>()
        input.map {
            val news = NewsEntity(
                urlToImage = it.urlToImage,
                author = it.author,
                title = it.title,
                url = it.url,
                publishedAt = it.publishedAt,
                content = it.content,
                isBookmark = false,
            )
            newsList.add(news)
        }
        return newsList
    }

    fun mapEntitiesToDomain(input: List<NewsEntity>): List<News> =
        input.map {
            News(
                urlToImage = it.urlToImage,
                author = it.author,
                title = it.title,
                url = it.url,
                publishedAt = it.publishedAt,
                content = it.content,
                isBookmark = it.isBookmark,
            )
        }

    fun mapDomainToEntity(input: News) = NewsEntity(
        author = input.author,
        title = input.title,
        url = input.url,
        urlToImage = input.urlToImage,
        publishedAt = input.publishedAt,
        content = input.content,
        isBookmark = input.isBookmark,
    )
}