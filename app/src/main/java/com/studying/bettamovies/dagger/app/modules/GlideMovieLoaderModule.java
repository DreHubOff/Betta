package com.studying.bettamovies.dagger.app.modules;

import android.content.Context;

import com.studying.bettamovies.data.GlideMovieLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class GlideMovieLoaderModule {

    @Provides
    @Singleton
    GlideMovieLoader provideGlideMovieLoader(Context context) {
        return new GlideMovieLoader(context);
    }
}
