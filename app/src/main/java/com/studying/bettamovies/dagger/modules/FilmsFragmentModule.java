package com.studying.bettamovies.dagger.modules;

import android.transition.Fade;

import com.studying.bettamovies.ui.main.list.FilmsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FilmsFragmentModule {

    @Singleton
    @Provides
    FilmsFragment provideFilmsFragment() {
        FilmsFragment f = new FilmsFragment();
        f.setExitTransition(new Fade());
        return f;
    }
}
