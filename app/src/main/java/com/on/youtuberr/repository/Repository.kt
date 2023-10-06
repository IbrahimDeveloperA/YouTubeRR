package com.on.youtuberr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.on.youtuberr.core.result.Resource
import com.on.youtuberr.data.RemoteDataSource
import com.on.youtuberr.data.remote.model.Playlist
import kotlinx.coroutines.Dispatchers

class Repository {
    private val datSource = RemoteDataSource()

    fun getPlaylist(): LiveData<Resource<Playlist>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = datSource.getPlaylist()
            emit(response)
        }
    }

    //    fun getPlaylist(): LiveData<Playlist> {
    //        var data = MutableLiveData<Playlist>()
    //        apiService.getPlaylist(
    //            "contentDetails,snippet",
    //            "UCWOA1ZGywLbqmigxE4Qlvuw",
    //            BuildConfig.API_KEY
    //        ).enqueue(object : Callback<Playlist>{
    //            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
    //                if (response.isSuccessful){
    //                    data = response.body()
    //                }
    //            }
    //
    //            override fun onFailure(call: Call<Playlist>, t: Throwable) {
    //               data.value = t.message.toString()
    //            }
    //
    //        })
    //
    //        return data
    //    }
}