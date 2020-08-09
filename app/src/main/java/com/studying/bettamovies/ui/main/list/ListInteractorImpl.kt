package com.studying.bettamovies.ui.main.list

import android.annotation.SuppressLint
import com.studying.bettamovies.models.ItemMovie
import com.studying.bettamovies.ui.main.list.interfaces.ListInteractor
import com.studying.bettamovies.ui.main.list.interfaces.ListRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

const val PAGE_COUNT: Int = 5

class ListInteractorImpl(val repository: ListRepository):
    ListInteractor {


    @SuppressLint("CheckResult")
    override fun getPopularMovies(): Single<List<ItemMovie>> {
            return repository.requestPopularMovies(PAGE_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}