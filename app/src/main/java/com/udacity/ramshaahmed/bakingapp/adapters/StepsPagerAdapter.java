package com.udacity.ramshaahmed.bakingapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.udacity.ramshaahmed.bakingapp.R;
import com.udacity.ramshaahmed.bakingapp.fragments.StepDetailFragment;
import com.udacity.ramshaahmed.bakingapp.models.Step;

import java.util.List;

public class StepsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Step> mSteps;

    public StepsPagerAdapter(Context context, List<Step> steps, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        this.mSteps = steps;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(StepDetailFragment.STEP_KEY, mSteps.get(position));
        StepDetailFragment fragment = new StepDetailFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(mContext.getString(R.string.step), position);
    }

    @Override
    public int getCount() {
        return mSteps.size();
    }

}
