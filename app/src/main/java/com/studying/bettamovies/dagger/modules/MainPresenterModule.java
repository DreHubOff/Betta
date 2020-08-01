package com.studying.bettamovies.dagger.modules;

import com.studying.bettamovies.ui.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(){
        return new MainPresenter();
    }
}
