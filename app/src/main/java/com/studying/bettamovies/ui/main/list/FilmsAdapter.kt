package com.studying.bettamovies.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.data.GlideMovieLoader
import com.studying.bettamovies.databinding.ItemFilmsBinding
import com.studying.bettamovies.ui.main.list.interfaces.OnFilmClickListener
import com.studying.bettamovies.models.ItemMovie
import javax.inject.Inject


class FilmsAdapter(private val listener: OnFilmClickListener) :
    RecyclerView.Adapter<FilmsAdapter.FilmsHolder>() {

    private val moviesListHolder = mutableListOf<ItemMovie>()

    @Inject
    lateinit var glideMovieLoader: GlideMovieLoader

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        (parent.context.applicationContext as App).appComponent.inject(this)
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_films,
            parent,
            false
        )
        return FilmsHolder(view, glideMovieLoader, listener)
    }

    override fun getItemCount() = moviesListHolder.size


    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.bind(moviesListHolder[position])
    }

    fun update(moviesList: List<ItemMovie>) {
        moviesListHolder.apply {
            clear()
            addAll(moviesList)
        }
        notifyDataSetChanged()
    }

    class FilmsHolder(
        itemView: View,
        private val glideLoader: GlideMovieLoader,
        private val listener: OnFilmClickListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemFilmsBinding = DataBindingUtil.bind(itemView)!!

        fun bind(movie: ItemMovie) {
            binding.movie = movie
            glideLoader.loadImage(binding.imgPoster, movie.posterURL)
            binding.itemRoot.setOnClickListener { listener.onFilmClick(movie.netId) }
        }

    }
}

