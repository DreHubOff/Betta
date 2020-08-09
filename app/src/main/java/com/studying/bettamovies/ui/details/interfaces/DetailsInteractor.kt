package com.studying.bettamovies.ui.details.interfaces

import com.studying.bettamovies.models.DetailsMovie
import io.reactivex.Single

interface DetailsInteractor {
    fun getMovieDetails(netId: Int): Single<DetailsMovie>
}