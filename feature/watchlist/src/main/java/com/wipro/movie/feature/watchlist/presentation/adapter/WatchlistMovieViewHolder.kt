package com.wipro.movie.feature.watchlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wipro.movie.core.common.base.BaseViewHolder
import com.wipro.movie.core.model.watchlist.WatchlistMovie
import com.wipro.movie.feature.watchlist.databinding.ListItemWatchlistMovieBinding

class WatchlistMovieViewHolder(
    private val parent: ViewGroup,
    private val onItemClicked: ((id: Int) -> Unit)?,
) : BaseViewHolder<WatchlistMovie, ListItemWatchlistMovieBinding>(
    binding = ListItemWatchlistMovieBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false,
    ),
) {
    override fun bind(item: WatchlistMovie) {
        with(binding) {
            Glide.with(parent.context).load(item.posterUrl).centerCrop()
                .into(listItemMovieWatchlistImageviewPoster)
            binding.root.setOnClickListener {
                onItemClicked?.invoke(item.id)
            }
        }
    }
}
