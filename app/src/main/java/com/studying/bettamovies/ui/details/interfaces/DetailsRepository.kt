package com.studying.bettamovies.ui.details.interfaces

import com.studying.bettamovies.interfaces.Repository
import com.studying.bettamovies.models.DetailsMovie
import io.reactivex.Single

interface DetailsRepository: Repository {
    fun requestMovieDetailsById(netId: Int): Single<DetailsMovie>
}