package com.on.youtuberr.data.remote

import com.on.youtuberr.data.remote.model.Playlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String
    ): Response<Playlist>

}