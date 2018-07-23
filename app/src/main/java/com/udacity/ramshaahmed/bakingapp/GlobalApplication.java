package com.udacity.ramshaahmed.bakingapp;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;

import com.udacity.ramshaahmed.bakingapp.resources.RecipesIdlingResource;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class GlobalApplication extends Application {
    @Nullable
    private RecipesIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link RecipesIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    private IdlingResource initializeIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new RecipesIdlingResource();
        }
        return mIdlingResource;
    }

    public GlobalApplication() {

        // The IdlingResource will be null in production.
        if (BuildConfig.DEBUG) {
            initializeIdlingResource();
        }

        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {

                return BuildConfig.DEBUG;
            }
        });

    }

    public void setIdleState(boolean state) {
        if (mIdlingResource != null)
            mIdlingResource.setIdleState(state);
    }

    @Nullable
    public RecipesIdlingResource getIdlingResource() {
        return mIdlingResource;
    }
}
