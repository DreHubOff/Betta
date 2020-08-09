package com.studying.bettamovies.ui.main.list

import androidx.fragment.app.Fragment
import com.studying.bettamovies.R
import com.studying.bettamovies.data.FragmentNavigator
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import com.studying.bettamovies.ui.main.list.interfaces.ListInteractor
import com.studying.bettamovies.ui.main.list.interfaces.ListPresenter
import com.studying.bettamovies.ui.main.list.interfaces.MyListView
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class ListPresenterImpl @Inject constructor(
    val interactor: ListInteractor,
    val detailsFragment: FilmDetailsFragment,
    val fragmentNavigator: FragmentNavigator,
    val disposable: CompositeDisposable
) : ListPresenter {

    var view: MyListView? = null


    override fun userSelectedMovie(netId: Int) {
        fragmentNavigator.showFragment(detailsFragment, R.id.main_container)
        detailsFragment.idMessage = Single.just(netId)
    }

    override fun bind(fragment: Fragment) {
        this.view = fragment as FilmsFragment
        disposable.add(
            interactor.getPopularMovies()
                .subscribe({
                    if (it.isNullOrEmpty()){
                        view?.showToast("oops, can't load the movie list")
                        view?.showErrorImage()
                    }
                    view?.updateUi(it)
                }, {
                    view?.showToast("oops, can't load the movie list")
                    view?.showErrorImage()
                })
        )
    }

    override fun unBind() {
        view = null
        disposable.dispose()
        disposable.clear()
    }
}


