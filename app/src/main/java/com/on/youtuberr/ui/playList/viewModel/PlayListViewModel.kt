package com.on.youtuberr.ui.playList.viewModel

import androidx.lifecycle.LiveData
import com.on.youtuberr.App
import com.on.youtuberr.core.result.Resource
import com.on.youtuberr.core.ui.BaseViewModel
import com.on.youtuberr.data.remote.model.Playlist

class PlayListViewModel : BaseViewModel() {

    fun getPlaylist(): LiveData<Resource<Playlist>> {
        return App.repository.getPlaylist()
    }

}