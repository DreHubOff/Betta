package com.studying.bettamovies.ui.main.list

import android.content.Context
import androidx.fragment.app.Fragment
import com.studying.bettamovies.R
import com.studying.bettamovies.App
import com.studying.bettamovies.data.FragmentNavigator
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.interfaces.Bindable
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import io.reactivex.Single
import javax.inject.Inject


class ListPresenter: Repository.OnRequestListener, Bindable {

    var view: MyListView? = null

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var detailsFragment: FilmDetailsFragment

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    fun userSelectedMovie(filmID: String) {
        detailsFragment.idMessage = Single.just(filmID)
        fragmentNavigator.showFragment(detailsFragment, R.id.main_container)
    }

    override fun onPopularListRequest(moviesList: List<MovieEntity>?) {
        if (moviesList.isNullOrEmpty()) view?.showToast("Internet connection error")
        else view?.updateUi(moviesList)
    }

    override fun bind(context: Context) {
        (context.applicationContext as App).appComponent.inject(this)
        repository.getMoviesList(this)
    }

    override fun unBind() {
        view = null
    }
}