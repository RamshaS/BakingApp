package com.udacity.ramshaahmed.bakingapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.udacity.ramshaahmed.bakingapp.Listners;
import com.udacity.ramshaahmed.bakingapp.R;
import com.udacity.ramshaahmed.bakingapp.models.Recipe;
import com.udacity.ramshaahmed.bakingapp.view_holders.RecipeViewHolder;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private Context mContext;
    private List<Recipe> mRecipes;
    private Listners.OnItemClickListener mOnItemClickListener;

    public RecipesAdapter(Context context, List<Recipe> recipes, Listners.OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mRecipes = recipes;
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);

        return new RecipeViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, final int position) {
        holder.mTvRecipeName.setText(mRecipes.get(position).getName());
        holder.mTvServings.setText(mContext.getString(R.string.servings, mRecipes.get(position).getServings()));

        String recipeImage = mRecipes.get(position).getImage();
        if (!recipeImage.isEmpty()) {
            Glide.with(mContext)
                    .load(recipeImage)
                    .into(holder.mIvRecipe);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }


}
