package com.studying.bettamovies.ui.main.list.data

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun getMoviesList(activity: FragmentActivity): Single<List<MovieEntity>> {
    return (activity.application as App).dataBase
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
        convertList(resList)
    } else {
        list
    }
}

fun addListToDataBase(genList: List<MovieEntity>, activity: FragmentActivity) {
    GlobalScope.launch {
        (activity.application as App).dataBase
            .getActivityDao()
            .insertAll(genList)
    }
}
