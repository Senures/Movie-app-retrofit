package com.semanureserler.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.semanureserler.movieapp.databinding.TvShowItemBinding
import com.semanureserler.movieapp.models.TvShowItem

class TvShowAdapter:RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    inner class TvShowViewHolder(val binding:TvShowItemBinding):RecyclerView.ViewHolder(binding.root)

    private  val diffCallback=object:DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
      return oldItem==newItem
        }

    }
    val differ=AsyncListDiffer(this,diffCallback)
    var tvshows:List<TvShowItem>
    //tanımladıgımız liste
    get() =differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
       return TvShowViewHolder(
           TvShowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val currentTvShow=tvshows[position]
        holder.binding.apply {
            textView.text=currentTvShow.name
            imageView.load(currentTvShow.image.original){
                crossfade(enable = true)
                crossfade(durationMillis =1000)
            }

        }
    }

    override fun getItemCount()=tvshows.size
}