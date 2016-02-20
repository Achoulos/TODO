package com.example.alex.simpletodo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Alex on 2/28/15.
 */
public class BootUpReceiver extends BroadcastReceiver {
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        boolean startUp = settings.getBoolean("startUp", false);
        if (!startUp) {
            settings = context.getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("startUp", true);
            editor.apply();
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }
}