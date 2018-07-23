package com.udacity.ramshaahmed.bakingapp.api;

public interface RecipesApiCallback<T> {
    void onResponse(T result);

    void onCancel();
}
