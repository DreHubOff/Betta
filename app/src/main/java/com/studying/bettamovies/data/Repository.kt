package com.studying.bettamovies.data

import android.annotation.SuppressLint
import android.content.Context
import android.transition.Fade
import android.transition.Transition
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.studying.bettamovies.db.DataBase
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.TimeUnit

class Repository(private val dataBase: DataBase, private val modelConverter: ModelConverter) {

    fun getMoviesList(): Single<List<MovieEntity>> {
        return dataBase
            .getActivityDao()
            .selectAll()
            .flatMap { Single.just(checkList(it)) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("CheckResult")
    private fun checkList(list: List<MovieEntity>): List<MovieEntity> {
        return if (list.isNullOrEmpty()) {
            val resList = mutableListOf<Movie>()
            for (i in 1..3) {
                ApiService.getPopularMovies(i)
                    .subscribe({
                        resList.addAll(it.movies)
                    }, { resList.clear() })
            }
            modelConverter.convertList(resList)
        } else {
            list
        }
    }

    fun addListToDataBase(genList: List<MovieEntity>) {
        GlobalScope.launch {
            dataBase
                .getActivityDao()
                .insertAll(genList)
        }
    }

    fun getMovieById(movieId: String): Single<MovieEntity> {
        return dataBase.getActivityDao()
            .getMovieById(movieId.toInt())
            .flatMap { Single.just(checkSingleMovie(it)) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("CheckResult")
    private fun checkSingleMovie(movie: MovieEntity): MovieEntity {
        var retMovie: MovieEntity? = null
        return if (movie.overview.isNullOrEmpty() || movie.genres.isNullOrEmpty()) {
            ApiService.getDetailsById(movie.movieID)
                .subscribe(
                    { retMovie = modelConverter.convertSingleMovie(it, movie) },
                    { retMovie = movie })

            retMovie!!
        } else {
            movie
        }
    }

    fun updateDataBase(movieEntity: MovieEntity) {
        dataBase.getActivityDao().updateSingle(movieEntity)
    }

    fun setupImage(image: ImageView, context: Context, movieEntity: MovieEntity) {
        Glide.with(context)
            .load(
                ApiService.getImageUrl(
                    if (movieEntity.backdropImageURL != null) {
                        movieEntity.backdropImageURL!!
                    } else {
                        movieEntity.image ?: "/nogV4th2P5QWYvQIMiWHj4CFLU9.jpg"
                    }
                )
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(image)
    }
}