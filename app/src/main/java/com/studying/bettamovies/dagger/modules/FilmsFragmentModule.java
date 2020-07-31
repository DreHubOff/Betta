package com.studying.bettamovies.dagger.modules;

import android.content.Context;
import android.transition.Fade;

import com.studying.bettamovies.App;
import com.studying.bettamovies.ui.main.list.FilmsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FilmsFragmentModule {

    @Singleton
    @Provides
    FilmsFragment provideFilmsFragment(Context context) {
        FilmsFragment f = new FilmsFragment((App)context);
        f.setExitTransition(new Fade());
        return f;
    }
}
