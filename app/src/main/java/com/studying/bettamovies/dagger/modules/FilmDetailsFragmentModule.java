package com.studying.bettamovies.dagger.modules;

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
        FilmDetailsFragment f = new FilmDetailsFragment((App)context);
        f.setEnterTransition(new Fade());
        return f;
    }
}
