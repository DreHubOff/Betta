package com.studying.bettamovies.ui.main.list.data

import androidx.fragment.app.FragmentActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun getMoviesList(activity: FragmentActivity): Single<List<MovieEntity>>{
    return (activity.application as App).dataBase
        .getActivityDao()
        .selectAll()
        .flatMap {(Single.just(it)) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

 //   ApiService.getPopularMovies(1)
//        .flatMap { firstList ->
//            val resList = mutableListOf<Movie>().apply { addAll(firstList.movies) }
//            for (i in 2..5) {
//                ApiService.getPopularMovies(i)
//                    .subscribe({
//                        resList.addAll(it.movies)
//                    }, {
//                        it.printStackTrace()
//                        view?.showToast("Some Error")
//                    })
//            }
//            Single.just(listOf(resList))
//        }
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
}