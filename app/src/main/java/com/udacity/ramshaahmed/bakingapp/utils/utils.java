package com.udacity.ramshaahmed.bakingapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.udacity.ramshaahmed.bakingapp.R;

public class utils {
    public static void makeSnackBar(Context context, View view, String text, boolean error) {
        final Snackbar snackbar;
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(ContextCompat.getColor(context, error ? R.color.colorError : R.color.colorInfo));
        TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(3);

        snackbar.show();
    }

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
