package com.dariwan.appnews.core.data.source.remote

import android.util.Log
import com.dariwan.appnews.core.data.source.remote.network.ApiResponse
import com.dariwan.appnews.core.data.source.remote.network.ApiService
import com.dariwan.appnews.core.data.source.remote.response.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllNews(): Flow<ApiResponse<List<NewsResponse>>> {
        return flow {
            try {
                val response = apiService.getAllNews()
                val dataArray = response.articles
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.articles))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSOurce", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}