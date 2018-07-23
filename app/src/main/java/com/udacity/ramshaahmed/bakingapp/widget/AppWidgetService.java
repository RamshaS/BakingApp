package com.udacity.ramshaahmed.bakingapp.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViewsService;

import com.udacity.ramshaahmed.bakingapp.models.Recipe;
import com.udacity.ramshaahmed.bakingapp.utils.Preferences;

public class AppWidgetService extends RemoteViewsService {
    public static void updateWidget(Context context, Recipe recipe) {
        Preferences.saveRecipe(context, recipe);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, AppWidget.class));
        AppWidget.updateAppWidgets(context, appWidgetManager, appWidgetIds);
    }
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);

        return new ListRemoteViewsFactory(getApplicationContext());
    }
}
