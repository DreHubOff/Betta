package com.studying.bettamovies.ui.main.list

import com.studying.bettamovies.R
import android.os.Build
import android.transition.Fade
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.studying.bettamovies.ui.animation.DetailsTransition
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import io.reactivex.disposables.Disposable


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
}