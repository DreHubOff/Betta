package com.studying.bettamovies

import android.app.Application
import com.bumptech.glide.Glide
import com.studying.bettamovies.dagger.app.AppComponent
import com.studying.bettamovies.dagger.app.DaggerAppComponent
import com.studying.bettamovies.dagger.app.modules.*
import com.studying.bettamovies.data.init


class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .baseModule(BaseModule(this))
            .filmsFragmentModule(FilmsFragmentModule())
            .mainPresenterModule(MainPresenterModule())
            .listPresenterModule(ListPresenterModule())
            .filmDetailsFragmentModule(FilmDetailsFragmentModule())
            .mainActivityHolderModule(MainActivityHolderModule())
            .fragmentNavigatorModule(FragmentNavigatorModule())
            .glideMovieLoaderModule(GlideMovieLoaderModule())
            .listInteractorModule(ListInteractorModule())
            .listRepositoryModule(ListRepositoryModule())
            .dataBaseModule(DataBaseModule())
            .detailsPresenterModule(DetailsPresenterModule())
            .detailsInteractorModule(DetailsInteractorModule())
            .detailsRepositoryModule(DetailsRepositoryModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Glide.get(this).init(this)
    }
}
