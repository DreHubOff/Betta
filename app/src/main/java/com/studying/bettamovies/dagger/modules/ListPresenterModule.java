package com.studying.bettamovies.dagger.modules;

import android.content.Context;

import com.studying.bettamovies.App;
import com.studying.bettamovies.ui.main.list.ListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class ListPresenterModule {
    @Provides
    @Singleton
    ListPresenter provideListPresenter(Context context){
        return new ListPresenter((App)context);
    }
}
