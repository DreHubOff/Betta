package com.studying.bettamovies.dagger.modules;

import android.content.Context;

import com.studying.bettamovies.App;
import com.studying.bettamovies.data.FragmentNavigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseModule.class)
public class FragmentNavigatorModule {
    @Provides
    @Singleton
    FragmentNavigator provideFragmentNavigator(Context context){
        return new FragmentNavigator((App)context);
    }
}
