package com.dariwan.appnews.core.data.source

import com.dariwan.appnews.core.data.NetworkBoundResource
import com.dariwan.appnews.core.data.Resource
import com.dariwan.appnews.core.data.source.local.LocalDataSource
import com.dariwan.appnews.core.data.source.remote.RemoteDataSource
import com.dariwan.appnews.core.data.source.remote.network.ApiResponse
import com.dariwan.appnews.core.data.source.remote.response.NewsResponse
import com.dariwan.appnews.core.domain.model.News
import com.dariwan.appnews.core.domain.repository.INewsRepository
import com.dariwan.appnews.core.utils.AppExecutors
import com.dariwan.appnews.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutors,
) : INewsRepository {
    override fun getAllNews(): Flow<Resource<List<News>>> =
        object : NetworkBoundResource<List<News>, List<NewsResponse>>() {
            override fun loadFromDB(): Flow<List<News>> {
                return localDataSource.getAllNews().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<News>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<NewsResponse>>> {
                return remoteDataSource.getAllNews()
            }

            override suspend fun saveCallResult(data: List<NewsResponse>) {
                val newsList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertNews(newsList)
            }

        }.asFLow()

    override fun getBookmarkNews(): Flow<List<News>> {
        return localDataSource.getBookmarkNews().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setBookmarkNews(news: News, state: Boolean) {
        val newsEntity = DataMapper.mapDomainToEntity(news)
        appExecutor.diskIO().execute { localDataSource.setBookmarkNews(newsEntity, state) }
    }
}