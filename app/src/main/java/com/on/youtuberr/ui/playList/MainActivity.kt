package com.on.youtuberr.ui.playList

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.on.youtuberr.core.result.Status
import com.on.youtuberr.core.ui.BaseActivity
import com.on.youtuberr.data.remote.model.Playlist
import com.on.youtuberr.databinding.ActivityMainBinding
import com.on.youtuberr.ext.ConnectionLiveData
import com.on.youtuberr.ui.playList.adapter.PlaylistsAdapter
import com.on.youtuberr.ui.playList.viewModel.PlayListViewModel

class MainActivity() : BaseActivity<ActivityMainBinding, PlayListViewModel>() {

    private val adapter = PlaylistsAdapter(this::onClick)

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun isConnection() {
        super.isConnection()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.noConnection.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            } else {
                binding.noConnection.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
                initViewModel()
            }
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylist().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.isVisible = false
                    adapter.addList(it.data?.items)
                }

                Status.ERROR -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, "This is a mistake", Toast.LENGTH_SHORT).show()
                }

                Status.LOADING -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerView.adapter = adapter
    }

    override fun initListener() {
        super.initListener()
    }

    private fun onClick(playlist: Playlist.Item) {

    }
}