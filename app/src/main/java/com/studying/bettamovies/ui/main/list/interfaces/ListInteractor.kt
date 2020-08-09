package com.studying.bettamovies.ui.main.list.interfaces

import com.studying.bettamovies.interfaces.Interactor
import com.studying.bettamovies.models.ItemMovie
import io.reactivex.Single

interface ListInteractor: Interactor {
    fun getPopularMovies(): Single<List<ItemMovie>>
}