package com.udacity.ramshaahmed.bakingapp.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.udacity.ramshaahmed.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ingredients_text)
    public TextView mTvIngredients;
    public IngredientsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
