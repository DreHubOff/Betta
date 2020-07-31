package com.studying.bettamovies.ui.main.list

import androidx.fragment.app.Fragment
import com.studying.bettamovies.R
import com.studying.bettamovies.App
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import io.reactivex.Single
import javax.inject.Inject


class ListPresenter (private val app: App): Repository.OnRequestListener {

    var view: MyListView? = null

    @Inject
    lateinit var repository: Repository
    @Inject
    lateinit var detailsFragment: FilmDetailsFragment

    init {
        app.appComponent.inject(this)
    }

    fun userSelectedMovie(filmID: String, filmsFragment :Fragment) {
        detailsFragment.idMessage = Single.just(filmID)
        filmsFragment.activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.main_container, detailsFragment)
            ?.commit()
    }

    fun userSeesView() {
        repository.getMoviesList(this)
    }

    override fun onPopularListRequest(moviesList: List<MovieEntity>?) {
        if (moviesList.isNullOrEmpty()) view?.showToast("Internet connection error")
        else view?.updateUi(moviesList)
    }
}