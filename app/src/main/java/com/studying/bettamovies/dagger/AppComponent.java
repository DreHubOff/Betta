package com.studying.bettamovies.dagger;


import com.studying.bettamovies.dagger.modules.BaseModule;
import com.studying.bettamovies.dagger.modules.FilmsFragmentModule;
import com.studying.bettamovies.dagger.modules.RepositoryModule;
import com.studying.bettamovies.ui.MainActivity;
import com.studying.bettamovies.ui.details.DetailsPresenter;
import com.studying.bettamovies.ui.main.list.FilmsFragment;
import com.studying.bettamovies.ui.main.list.ListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        BaseModule.class,
        FilmsFragmentModule.class,
        RepositoryModule.class
})

public interface AppComponent {
    void inject(ListPresenter listPresenter);
    void inject(MainActivity mainActivity);
    void inject(DetailsPresenter detailsPresenter);
}