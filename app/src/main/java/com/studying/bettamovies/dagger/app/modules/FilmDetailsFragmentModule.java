package com.studying.bettamovies.dagger.app.modules;

import android.content.Context;
import android.transition.Fade;

import com.studying.bettamovies.App;
import com.studying.bettamovies.ui.details.FilmDetailsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FilmDetailsFragmentModule {

    @Provides
    @Singleton
    FilmDetailsFragment provideFilmDetailsFragment(Context context){
        FilmDetailsFragment f = new FilmDetailsFragment();
        f.setEnterTransition(new Fade());
        return f;
    }
}
