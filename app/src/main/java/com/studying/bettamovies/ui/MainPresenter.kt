package com.studying.bettamovies.ui

import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.Transition
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.data.FragmentNavigator
import com.studying.bettamovies.data.MainActivityHolder
import com.studying.bettamovies.interfaces.BindableActivity
import com.studying.bettamovies.ui.main.list.FilmsFragment
import javax.inject.Inject

class MainPresenter @Inject constructor(
    var filmsFragment: FilmsFragment,
    var mainActivityHolder: MainActivityHolder,
    var fragmentNavigator: FragmentNavigator
) : BindableActivity {

    private var view: MainView? = null

    override fun bind(activity: AppCompatActivity) {
        (activity.application as App).appComponent.inject(this)
        view = activity as MainActivity

        mainActivityHolder.bind(activity)

        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, filmsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    override fun unBind() {
        view = null
        mainActivityHolder.unBind()
    }

    fun backWasPressed() {
        if (filmsFragment.isResumed)
            mainActivityHolder.mySingleActivity?.finish()
    }

}