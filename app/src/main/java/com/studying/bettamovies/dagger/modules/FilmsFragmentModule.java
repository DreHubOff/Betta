package com.studying.bettamovies.dagger.modules;

import com.studying.bettamovies.ui.main.list.FilmsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FilmsFragmentModule {

    @Singleton
    @Provides
    FilmsFragment provideFilmsFragment() {
        return FilmsFragment.Companion.getInstance();
    }
}
