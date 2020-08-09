package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.db.DataBase;
import com.studying.bettamovies.ui.main.list.ListRepositoryImpl;
import com.studying.bettamovies.ui.main.list.interfaces.ListRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataBaseModule.class)
public class ListRepositoryModule {

    @Provides
    @Singleton
    ListRepository provideListRepository(DataBase dataBase){
        return new ListRepositoryImpl(dataBase);
    }
}
