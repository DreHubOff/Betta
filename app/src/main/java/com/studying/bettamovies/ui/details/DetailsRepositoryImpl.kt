package com.studying.bettamovies.ui.details

import com.studying.bettamovies.data.ModelConverter
import com.studying.bettamovies.db.DataBase
import com.studying.bettamovies.models.DetailsMovie
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.ui.details.interfaces.DetailsRepository
import io.reactivex.Single

class DetailsRepositoryImpl(val dataBase: DataBase) : DetailsRepository {

    override fun requestMovieDetailsById(netId: Int): Single<DetailsMovie> {
        return dataBase.getMovieDetailsDao().getMovieById(netId)
            .flatMap {
                Single.just(ModelConverter.convertMovieDetailsEntityToDetailsMovie(it))
            }.doOnError {
                ApiService.getDetailsById(netId)
                    .flatMap {
                        Single.just(ModelConverter.convertFilmDetailsRequestToDetailsMovie(it))
                    }
            }
    }
}