package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.data.FragmentNavigator;
import com.studying.bettamovies.data.MainActivityHolder;
import com.studying.bettamovies.ui.MainPresenter;
import com.studying.bettamovies.ui.main.list.FilmsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {FilmsFragmentModule.class, MainActivityHolderModule.class, FragmentNavigatorModule.class})
public class MainPresenterModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(
            FilmsFragment filmsFragment,
            MainActivityHolder mainActivityHolder,
            FragmentNavigator fragmentNavigator
    ){
        return new MainPresenter(filmsFragment, mainActivityHolder, fragmentNavigator);
    }
}
