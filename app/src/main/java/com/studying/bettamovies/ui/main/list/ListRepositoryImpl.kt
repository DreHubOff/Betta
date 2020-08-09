package com.studying.bettamovies.ui.main.list

import android.annotation.SuppressLint
import com.studying.bettamovies.data.ModelConverter
import com.studying.bettamovies.db.DataBase
import com.studying.bettamovies.db.models.MovieItemEntity
import com.studying.bettamovies.models.ItemMovie
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.ui.main.list.interfaces.ListRepository
import io.reactivex.Single

class ListRepositoryImpl constructor(
    val dataBase: DataBase
) : ListRepository {

    @SuppressLint("CheckResult")
    override fun requestPopularMovies(pageCount: Int): Single<List<ItemMovie>> {
        return dataBase.getMovieItemDao().selectAll()
            .flatMap {
                Single.just(checkList(it, pageCount))
            }
    }

    @SuppressLint("CheckResult")
    private fun checkList(list: List<MovieItemEntity>, pageCount: Int): List<ItemMovie> {
        return if (list.isNullOrEmpty()) {
            val resList = mutableListOf<ItemMovie>()
            for (i in 1..pageCount) {
                ApiService.getPopularMovies(i)
                    .subscribe({
                        resList.addAll(ModelConverter.convertRequestModelToItemModel_List(it))
                    }, { resList.clear() })
            }
            resList
        } else {
            ModelConverter.convertMovieItemEntityToItemModel_List(list)
        }
    }

}