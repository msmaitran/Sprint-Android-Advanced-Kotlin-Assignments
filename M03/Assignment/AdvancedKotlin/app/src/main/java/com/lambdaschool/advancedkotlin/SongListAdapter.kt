package com.lambdaschool.advancedkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.song_item_layout.view.*

class SongListAdapter (val data: List<Song>) : RecyclerView.Adapter<SongListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val songTitle: TextView = view.tv_song_name
        val songArtist: TextView = view.tv_artist_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongListAdapter.ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.song_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SongListAdapter.ViewHolder, position: Int) {
        val song = data[position]
        holder.songTitle.text = song.name
        holder.songArtist.text = song.artist
    }
}