package com.studying.bettamovies.dagger.app.modules;

import android.content.Context;

import com.studying.bettamovies.db.DataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {
    @Provides
    @Singleton
    DataBase provideDataBase(Context context){
        return DataBase.Companion.getInstance(context);
    }
}
