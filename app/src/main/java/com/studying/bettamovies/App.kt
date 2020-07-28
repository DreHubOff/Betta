package com.studying.bettamovies

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.studying.bettamovies.dagger.AppComponent
import com.studying.bettamovies.dagger.DaggerAppComponent
import com.studying.bettamovies.dagger.modules.BaseModule
import com.studying.bettamovies.dagger.modules.FilmsFragmentModule
import com.studying.bettamovies.dagger.modules.RepositoryModule
import com.studying.bettamovies.data.init


class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .baseModule(BaseModule(this))
            .repositoryModule(RepositoryModule())
            .filmsFragmentModule(FilmsFragmentModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Glide.get(this).init(this)
    }
}
