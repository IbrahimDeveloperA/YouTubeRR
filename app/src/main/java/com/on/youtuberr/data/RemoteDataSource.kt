package com.on.youtuberr.data

import com.on.youtuberr.BuildConfig
import com.on.youtuberr.core.RetrofitClient
import com.on.youtuberr.core.result.Resource
import com.on.youtuberr.core.ui.BaseDataSource
import com.on.youtuberr.data.remote.ApiService
import com.on.youtuberr.data.remote.model.Playlist

class RemoteDataSource : BaseDataSource() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    suspend fun getPlaylist(): Resource<Playlist> {
        return getResult {
            apiService.getPlaylist(
                "contentDetails,snippet",
                "UCWOA1ZGywLbqmigxE4Qlvuw",
                BuildConfig.API_KEY
            )
        }
    }
}