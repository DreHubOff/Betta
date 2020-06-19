package com.studying.bettamovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import kotlinx.android.synthetic.main.item_films.view.*

class FilmsAdapter(private val listener: OnFilmClickListener) : RecyclerView.Adapter<FilmsAdapter.FilmsHolder>() {

    private val listOfFilms = mutableListOf<Movie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)
        return FilmsHolder(v, listener)
    }

    override fun getItemCount() = listOfFilms.size


    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.bind(listOfFilms[position])
    }

    class FilmsHolder(
        itemView: View,
        var listener: OnFilmClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        private var nameUI: TextView = itemView.txt_name
        private var popularityUI: TextView = itemView.txt_popularity
        private var posterUI: ImageView = itemView.img_poster
        private var root: View = itemView.item_root

        fun bind(movie: Movie) {
            nameUI.text = movie.name
            popularityUI.text = movie.popularity.toString()
            Glide.with(itemView.context)
                .load(ApiService.getImageUrl(movie.image))
                .into(posterUI)
            root.setOnClickListener { listener.onFilmClick(movie.id) }
        }
    }

    fun update(list: List<Movie>) {
        listOfFilms.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }
}

