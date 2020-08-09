package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.db.DataBase;
import com.studying.bettamovies.ui.details.DetailsRepositoryImpl;
import com.studying.bettamovies.ui.details.interfaces.DetailsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataBaseModule.class)
public class DetailsRepositoryModule {
    @Provides
    @Singleton
    DetailsRepository provideDetailsRepository(DataBase dataBase) {
        return new DetailsRepositoryImpl(dataBase);
    }
}
