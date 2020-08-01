package com.studying.bettamovies.dagger.modules;

import com.studying.bettamovies.ui.main.list.ListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module()
public class ListPresenterModule {
    @Provides
    @Singleton
    ListPresenter provideListPresenter(){
        return new ListPresenter();
    }
}
