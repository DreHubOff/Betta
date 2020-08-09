package com.studying.bettamovies.ui.details

import com.studying.bettamovies.models.DetailsMovie
import com.studying.bettamovies.ui.details.interfaces.DetailsInteractor
import com.studying.bettamovies.ui.details.interfaces.DetailsRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsInteractorImpl(val repository: DetailsRepository): DetailsInteractor{
    override fun getMovieDetails(netId: Int): Single<DetailsMovie> {
        return repository.requestMovieDetailsById(netId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}