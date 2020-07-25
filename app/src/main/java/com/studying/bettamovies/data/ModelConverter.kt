package com.studying.bettamovies.data

import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.models.FilmDetails
import com.studying.bettamovies.network.models.Movie

class ModelConverter {

    fun convertList(movieList: MutableList<Movie>): List<MovieEntity> {
        val list = mutableListOf<MovieEntity>()
        movieList.forEach { movie ->
            list.add(
                MovieEntity(
                    movie.popularity,
                    movie.image,
                    movie.id.toInt(),
                    movie.name,
                    movie.language

                )
            )
        }
        return list.toList()
    }

    fun convertSingleMovie(movieDetails: FilmDetails, movieEntity: MovieEntity) =
        movieEntity.apply {
            genres = movieDetails.genres.joinToString(",")
            budget = movieDetails.budget
            homepage = movieDetails.homepage
            overview = movieDetails.overview
            releaseDate = movieDetails.releaseDate
            runtime = movieDetails.runtime
            backdropImageURL = movieDetails.backdropImageURL
        }
}