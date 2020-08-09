package com.studying.bettamovies.data;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class FragmentNavigator {
    MainActivityHolder mainActivityHolder;

    @Inject
    public FragmentNavigator(MainActivityHolder mainActivityHolder) {
        this.mainActivityHolder = mainActivityHolder;
    }

    public void showFragment(Fragment fragment, int container) {
        mainActivityHolder.getMySingleActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commitNow();
    }
}
