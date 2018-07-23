package com.udacity.ramshaahmed.bakingapp.utils;

import android.support.test.espresso.contrib.RecyclerViewActions;

import com.udacity.ramshaahmed.bakingapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Navigation {
    public static void getMeToRecipeInfo(int recipePosition) {
        onView(withId(R.id.recipes_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(recipePosition, click()));
    }

    public static void selectRecipeStep(int recipeStep) {
        onView(withId(R.id.recipe_step_list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(recipeStep, click()));
    }

}
