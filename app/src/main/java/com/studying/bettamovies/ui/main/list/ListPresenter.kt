package com.studying.bettamovies.ui.main.list

import com.studying.bettamovies.R
import android.os.Build
import android.transition.Fade
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import com.studying.bettamovies.ui.animation.DetailsTransition
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ListPresenter {

    var view: MyListView? = null
    lateinit var disposable: Disposable
    lateinit var activity: FragmentActivity

    fun userSelectedMovie(filmID: String, root: View) {
        val detailsFragment = FilmDetailsFragment.getInstance(filmID)?.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                sharedElementEnterTransition = DetailsTransition()
                enterTransition = Fade()
                sharedElementReturnTransition = DetailsTransition()
            }
        }

        val frTransition = activity.supportFragmentManager
            .beginTransaction()
            .addSharedElement(root, "transitionImage")
            .replace(R.id.main_container, detailsFragment!!)
            .addToBackStack(null)

        view?.showDetails(frTransition)
    }

    fun userSeeView() {
        if (generalList.isEmpty()) {
          //  disposable =
               val v=  ApiService.getPopularMovies(1)
                .flatMap { firstList ->
                    val resList = mutableListOf<Movie>().apply { addAll(firstList.movies) }
                    for (i in 2..5) {
                        ApiService.getPopularMovies(i)
                            .subscribe({
                                resList.addAll(it.movies)
                            }, {
                                it.printStackTrace()
                                view?.showToast("Some Error")
                            })
                    }
                    Single.just(resList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    view?.updateUi(it)
//                    generalList.apply {
//                        clear()
//                        addAll(it)
//                    }
//                }, { it.printStackTrace() })
        } else {
            view?.updateUi(generalList)
        }
    }
}