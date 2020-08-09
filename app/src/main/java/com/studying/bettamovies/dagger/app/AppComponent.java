package com.studying.bettamovies.dagger.app;


import com.studying.bettamovies.dagger.app.modules.BaseModule;
import com.studying.bettamovies.dagger.app.modules.DataBaseModule;
import com.studying.bettamovies.dagger.app.modules.DetailsInteractorModule;
import com.studying.bettamovies.dagger.app.modules.DetailsPresenterModule;
import com.studying.bettamovies.dagger.app.modules.DetailsRepositoryModule;
import com.studying.bettamovies.dagger.app.modules.FilmDetailsFragmentModule;
import com.studying.bettamovies.dagger.app.modules.FilmsFragmentModule;
import com.studying.bettamovies.dagger.app.modules.FragmentNavigatorModule;
import com.studying.bettamovies.dagger.app.modules.GlideMovieLoaderModule;
import com.studying.bettamovies.dagger.app.modules.ListInteractorModule;
import com.studying.bettamovies.dagger.app.modules.ListPresenterModule;
import com.studying.bettamovies.dagger.app.modules.ListRepositoryModule;
import com.studying.bettamovies.dagger.app.modules.MainPresenterModule;
import com.studying.bettamovies.dagger.app.modules.MainActivityHolderModule;
import com.studying.bettamovies.data.FragmentNavigator;
import com.studying.bettamovies.ui.MainActivity;
import com.studying.bettamovies.ui.MainPresenter;
import com.studying.bettamovies.ui.details.DetailsPresenterImpl;
import com.studying.bettamovies.ui.details.FilmDetailsFragment;
import com.studying.bettamovies.ui.details.interfaces.DetailsInteractor;
import com.studying.bettamovies.ui.main.list.FilmsAdapter;
import com.studying.bettamovies.ui.main.list.FilmsFragment;
import com.studying.bettamovies.ui.main.list.ListPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        BaseModule.class,
        FilmsFragmentModule.class,
        ListPresenterModule.class,
        FilmDetailsFragmentModule.class,
        MainPresenterModule.class,
        MainActivityHolderModule.class,
        FragmentNavigatorModule.class,
        GlideMovieLoaderModule.class,
        ListInteractorModule.class,
        ListRepositoryModule.class,
        DataBaseModule.class,
        DetailsPresenterModule.class,
        DetailsInteractorModule.class,
        DetailsRepositoryModule.class
})

public interface AppComponent {
    void inject(ListPresenterImpl listPresenterImpl);
    void inject(MainActivity mainActivity);
    void inject(FilmDetailsFragment filmDetailsFragment);
    void inject(FilmsFragment filmsFragment);
    void inject(MainPresenter mainPresenter);
    void inject(FragmentNavigator fragmentNavigator);
    void inject(FilmsAdapter filmsAdapter);
}
