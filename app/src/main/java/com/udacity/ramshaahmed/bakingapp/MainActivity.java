package com.udacity.ramshaahmed.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udacity.ramshaahmed.bakingapp.fragments.RecipesFragment;
import com.udacity.ramshaahmed.bakingapp.models.Recipe;

public class MainActivity extends AppCompatActivity implements RecipesFragment.OnRecipeClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRecipeSelected(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra(RecipeDetailActivity.RECIPE_KEY, recipe);
        startActivity(intent);
    }
}
