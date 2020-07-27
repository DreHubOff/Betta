package com.studying.bettamovies.dagger.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {
    private final Context context;

    public BaseModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    Context provideAppContext() {
        return context;
    }
}
