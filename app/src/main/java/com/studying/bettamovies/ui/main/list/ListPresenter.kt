package com.studying.bettamovies.ui.main.list

import android.app.Activity
import com.studying.bettamovies.R
import android.os.Build
import android.transition.Fade
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.ui.MainActivity
import com.studying.bettamovies.ui.animation.DetailsTransition
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton


class ListPresenter (private val activity: MainActivity) {

    var view: MyListView? = null
    var disposable: Disposable? = null

    @Inject
    lateinit var repository: Repository
    init {
        (activity.applicationContext as App).appComponent.inject(this)
    }

    fun userSelectedMovie(filmID: String, root: View) {
        val detailsFragment = FilmDetailsFragment
            .getInstance(activity, filmID).apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    sharedElementEnterTransition = DetailsTransition()
                    enterTransition = Fade()
                    sharedElementReturnTransition = DetailsTransition()
                }
            }

        val frTransition = activity.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .addSharedElement(root, "transitionImage")
            .replace(R.id.main_container, detailsFragment)


        view?.showDetails(frTransition)
    }

    fun userSeesView() {
        disposable = repository.getMoviesList().subscribe({
            repository.addListToDataBase(it)
            view?.updateUi(it)
        }, {
            it.printStackTrace()
            view?.showToast("Internet connection error")
        })
    }
}