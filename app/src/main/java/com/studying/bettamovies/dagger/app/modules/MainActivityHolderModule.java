package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.data.MainActivityHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityHolderModule {

    @Provides
    @Singleton
    MainActivityHolder provideMyActivityHolder(){
        return new MainActivityHolder();
    }
}
