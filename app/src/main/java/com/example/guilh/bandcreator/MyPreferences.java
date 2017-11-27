package com.example.guilh.bandcreator;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    private static final String MY_PREFERENCES = "my_preferences";

    public static boolean isFirst(Context context){
        final SharedPreferences reader = context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        final boolean first = reader.getBoolean("is_first", true);
        if(first){
            final SharedPreferences.Editor editor = reader.edit();
            editor.putBoolean("is_first", false);
            editor.commit();
        }
        return first;
    }
    public static String isLogged(Context context, String usuario, String password){
        final SharedPreferences reader = context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        final String user = reader.getString("usuario", null);
        if(user != null){
            final SharedPreferences.Editor editor = reader.edit();
            editor.putString("usuario", usuario);
            editor.putString("password", password);
            editor.commit();
        }
        return isLogged(context, usuario, password);
    }
}