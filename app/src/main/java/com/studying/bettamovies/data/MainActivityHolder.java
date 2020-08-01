package com.studying.bettamovies.data;

import android.content.Context;

import com.studying.bettamovies.interfaces.Bindable;
import com.studying.bettamovies.ui.MainActivity;

import org.jetbrains.annotations.NotNull;

public class MainActivityHolder implements Bindable {

    private MainActivity mySingleActivity = null;

    public MainActivity getMySingleActivity() {
        return mySingleActivity;
    }

    @Override
    public void bind(@NotNull Context context) {
        if (context instanceof MainActivity) {
            mySingleActivity = (MainActivity) context;
        }
    }

    @Override
    public void unBind() {
        mySingleActivity = null;
    }
}
