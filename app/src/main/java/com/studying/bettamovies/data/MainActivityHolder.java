package com.studying.bettamovies.data;


import androidx.appcompat.app.AppCompatActivity;

import com.studying.bettamovies.interfaces.BindableActivity;

import org.jetbrains.annotations.NotNull;

public class MainActivityHolder implements BindableActivity {

    private AppCompatActivity mySingleActivity = null;

    public AppCompatActivity getMySingleActivity() {
        return mySingleActivity;
    }

    @Override
    public void bind(@NotNull AppCompatActivity activity) {
            mySingleActivity = activity;
    }

    @Override
    public void unBind() {
        mySingleActivity = null;
    }
}
