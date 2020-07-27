package com.studying.bettamovies.dagger.modules;


import android.content.Context;

import com.studying.bettamovies.data.ModelConverter;
import com.studying.bettamovies.data.Repository;
import com.studying.bettamovies.db.DataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class RepositoryModule {

    @Singleton
    @Provides
    Repository provideRepository(Context context) {
        DataBase db = DataBase.Companion.getInstance(context);
        return new Repository(db, new ModelConverter());
    }
}
