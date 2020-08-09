package com.studying.bettamovies.data

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.studying.bettamovies.db.DataBase
import com.studying.bettamovies.db.models.MovieItemEntity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.ItemMovieRequest
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repository(private val dataBase: DataBase) {

//    @SuppressLint("CheckResult")
//    fun getMoviesList(onRequestListener: OnRequestListener?) {
//        dataBase.getMovieItemDao()
//            .selectAll()
//            .flatMap { Single.just(checkList(it)) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                onRequestListener?.onPopularListRequest(it)
//                addListToDataBase(it)
//            }, {
//                onRequestListener?.onPopularListRequest(null)
//            })
//    }
//
//    @SuppressLint("CheckResult")
//    private fun checkList(list: List<MovieItemEntity>): List<MovieItemEntity> {
//        return if (list.isNullOrEmpty()) {
//            val resList = mutableListOf<ItemMovieRequest>()
//            for (i in 1..3) {
//                ApiService.getPopularMovies(i)
//                    .subscribe({
//                        resList.addAll(it.itemMovieRequests)
//                    }, { resList.clear() })
//            }
//            modelConverter.convertList(resList)
//        } else {
//            list
//        }
//    }
//
//    private fun addListToDataBase(genList: List<MovieItemEntity>) {
//        GlobalScope.launch {
//            dataBase
//                .getMovieItemDao()
//                .insertAll(genList)
//        }
//    }
//
//    fun getMovieById(movieId: String): Single<MovieItemEntity> {
//        return dataBase.getMovieItemDao()
//            .getMovieById(movieId.toInt())
//            .flatMap { Single.just(checkSingleMovie(it)) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//    }
//
//    @SuppressLint("CheckResult")
//    private fun checkSingleMovie(movieItem: MovieItemEntity): MovieItemEntity {
//        var retMovie: MovieItemEntity? = null
//        return if (movieItem.overview.isNullOrEmpty() || movieItem.genres.isNullOrEmpty()) {
//            ApiService.getDetailsById(movieItem.movieID)
//                .subscribe(
//                    { retMovie = modelConverter.convertSingleMovie(it, movieItem) },
//                    { retMovie = movieItem })
//
//            retMovie!!
//        } else {
//            movieItem
//        }
//    }
//
//    fun updateDataBase(movieItemEntity: MovieItemEntity) {
//        dataBase.getMovieItemDao().updateSingle(movieItemEntity)
//    }
//
//    fun setupImage(image: ImageView, context: Context, movieItemEntity: MovieItemEntity) {
//        Glide.with(context)
//            .load(
//                ApiService.getImageUrl(
//                    if (movieItemEntity.backdropImageURL != null) {
//                        movieItemEntity.backdropImageURL!!
//                    } else {
//                        movieItemEntity.image ?: "/nogV4th2P5QWYvQIMiWHj4CFLU9.jpg"
//                    }
//                )
//            )
//            .transition(DrawableTransitionOptions.withCrossFade())
//            .into(image)
//    }
//
//    interface OnRequestListener {
//        fun onPopularListRequest(moviesList: List<MovieItemEntity>?)
//    }
}