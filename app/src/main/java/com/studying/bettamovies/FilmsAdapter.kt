package com.studying.bettamovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_films.view.*

class FilmsAdapter() : RecyclerView.Adapter<FilmsAdapter.FilmsHolder>() {

    private val listOfFilms: MutableList<RequestModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_films, parent, false)
        return FilmsHolder(v)
    }

    override fun getItemCount() = listOfFilms.size


    override fun onBindViewHolder(holder: FilmsHolder, position: Int) {
        holder.bind(listOfFilms[position])
    }

    class FilmsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var nameUI: TextView = itemView.txt_name
        private var popularityUI: TextView = itemView.txt_popularity
        private var posterUI:ImageView = itemView.img_poster

        fun bind(film: Any){
            nameUI.text = film.name
            popularityUI.text = film.popularity
            Glide.with(itemView.context)
                .load(film.URL)
                .into(posterUI)
        }
    }

    fun update(listOfFilm: List<>) {
        listOfFilm.apply {
            clear()
            addAll(listOfDrinks)
        }
        notifyDataSetChanged()
    }
}

