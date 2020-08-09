package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.data.FragmentNavigator;
import com.studying.bettamovies.data.Repository;
import com.studying.bettamovies.ui.details.FilmDetailsFragment;
import com.studying.bettamovies.ui.main.list.ListPresenterImpl;
import com.studying.bettamovies.ui.main.list.interfaces.ListInteractor;
import com.studying.bettamovies.ui.main.list.interfaces.ListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {ListInteractorModule.class, FilmDetailsFragmentModule.class, FragmentNavigatorModule.class})
public class ListPresenterModule {
    @Provides
    @Singleton
    ListPresenter provideListPresenter(
            ListInteractor interactor,
            FilmDetailsFragment detailsFragment,
            FragmentNavigator fragmentNavigator
    ) {
        return new ListPresenterImpl(interactor, detailsFragment, fragmentNavigator, new CompositeDisposable());
    }
}
