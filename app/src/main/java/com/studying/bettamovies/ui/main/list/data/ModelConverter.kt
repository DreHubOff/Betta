package com.studying.bettamovies.ui.main.list.data

import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.models.Movie

fun convertList(movieList: MutableList<Movie>): List<MovieEntity> {
    val list = mutableListOf<MovieEntity>()
    movieList.forEach { movie ->
        list.add(
            MovieEntity(
                movie.popularity,
                movie.image,
                movie.id,
                movie.name,
                movie.language
            )
        )
    }
    return list.toList()
}