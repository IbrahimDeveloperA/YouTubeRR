package com.on.youtuberr.ui.playList.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.on.youtuberr.data.remote.model.Playlist
import com.on.youtuberr.databinding.ItemListBinding
import com.on.youtuberr.ext.loadImage

class PlaylistsAdapter(private val onClick: (Playlist.Item) -> Unit) :
    RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var list = ArrayList<Playlist.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Playlist.Item?>?) {
        this.list = list as ArrayList<Playlist.Item>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size;

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class PlaylistsViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(playlist: Playlist.Item) {
            binding.nameList.text = playlist.snippet.title

            binding.descList.text = playlist.contentDetails.itemCount.toString() + " video series"
            binding.imgList.loadImage(playlist.snippet.thumbnails.default.url)
            binding.cardView.setOnClickListener {
                onClick.invoke(playlist)
            }
        }
    }
}