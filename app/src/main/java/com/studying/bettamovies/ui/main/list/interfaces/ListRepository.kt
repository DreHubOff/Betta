package com.studying.bettamovies.ui.main.list.interfaces

import com.studying.bettamovies.interfaces.Repository
import com.studying.bettamovies.models.ItemMovie
import io.reactivex.Single

interface ListRepository: Repository {
    fun requestPopularMovies(pageCount: Int): Single<List<ItemMovie>>
}