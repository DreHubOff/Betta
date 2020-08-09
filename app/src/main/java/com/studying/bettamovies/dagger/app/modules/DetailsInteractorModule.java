package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.db.DataBase;
import com.studying.bettamovies.ui.details.DetailsInteractorImpl;
import com.studying.bettamovies.ui.details.interfaces.DetailsInteractor;
import com.studying.bettamovies.ui.details.interfaces.DetailsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = DetailsRepositoryModule.class)
public class DetailsInteractorModule {
    @Provides
    @Singleton
    DetailsInteractor provideDetailsInteractorModule(DetailsRepository detailsRepository) {
        return new DetailsInteractorImpl(detailsRepository);
    }
}
