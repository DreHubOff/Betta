package com.studying.bettamovies.ui

import android.content.Context
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.data.FragmentNavigator
import com.studying.bettamovies.data.MainActivityHolder
import com.studying.bettamovies.interfaces.Bindable
import com.studying.bettamovies.ui.main.list.FilmsFragment
import javax.inject.Inject

class MainPresenter : Bindable {

    @Inject
    lateinit var filmsFragment: FilmsFragment

    @Inject
    lateinit var mainActivityHolder: MainActivityHolder

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    private var view: MainView? = null

    override fun bind(context: Context) {
        (context.applicationContext as App).appComponent.inject(this)
        mainActivityHolder.bind(context)
        fragmentNavigator.showFragment(filmsFragment, R.id.main_container)

        view = mainActivityHolder.mySingleActivity
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