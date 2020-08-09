package com.studying.bettamovies.dagger.app.modules;

import com.studying.bettamovies.data.FragmentNavigator;
import com.studying.bettamovies.data.MainActivityHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = MainActivityHolderModule.class)
public class FragmentNavigatorModule {
    @Provides
    @Singleton
    FragmentNavigator provideFragmentNavigator(MainActivityHolder mainActivityHolder){
        return new FragmentNavigator(mainActivityHolder);
    }
}
