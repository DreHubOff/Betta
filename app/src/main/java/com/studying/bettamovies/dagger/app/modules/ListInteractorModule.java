package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.ui.main.list.ListInteractorImpl;
import com.studying.bettamovies.ui.main.list.interfaces.ListInteractor;
import com.studying.bettamovies.ui.main.list.interfaces.ListRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ListInteractorModule {
    @Provides
    @Singleton
    ListInteractor provideListInteractor(ListRepository repository){
        return new ListInteractorImpl(repository);
    }
}
