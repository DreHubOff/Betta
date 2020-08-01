package com.studying.bettamovies.data;

import androidx.fragment.app.Fragment;

import com.studying.bettamovies.App;

import javax.inject.Inject;

public class FragmentNavigator {

    @Inject
    MainActivityHolder mainActivityHolder;

    public FragmentNavigator(App app) {
        app.getAppComponent().inject(this);
    }

    public void showFragment(Fragment fragment, int container) {
        mainActivityHolder.getMySingleActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
