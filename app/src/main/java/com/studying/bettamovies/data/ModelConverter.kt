package com.studying.bettamovies.data

import android.content.Intent
import android.net.Uri
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.models.FilmDetails
import com.studying.bettamovies.network.models.Movie
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*

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
            genres = validateInputData(movieDetails.genres.joinToString { "${it.GenreName} " })
            budget =  validateInputData(movieDetails.budget,"\$")
            homepage = validateInputData(movieDetails.homepage)
            overview = validateInputData(movieDetails.overview)
            releaseDate = validateInputData(movieDetails.releaseDate)
            runtime = validateInputData(movieDetails.runtime, "min")
            backdropImageURL = movieDetails.backdropImageURL

        }
}