package com.aaratechnologies.fourcutss.Utils.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;



public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "Fourcutss";
    private static final String LoginRole = "LoginRole";
    private static final String Password = "Password";
    private static final String Username = "Username";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences

//    public void userLogin(ModelLogin user) {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(LoginRole, user.getLoginRole());
//        editor.putString(Password, user.getPassword());
//        editor.putString(Username, user.getUsername());
//
//        editor.apply();
//    }
//    //this method will checker whether user is already logged in or not
//    public boolean isLoggedIn() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(LoginRole, null) != null;
//    }
//
//    //this method will give the logged in user
//    public ModelLogin getUser() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        return new ModelLogin(
//                sharedPreferences.getString(LoginRole, null),
//                sharedPreferences.getString(Username, null),
//                sharedPreferences.getString(Password, null)
//
//        );
//    }
//
//    //this method will logout the user
//    public void logout() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//        mCtx.startActivity(new Intent(mCtx, Login.class));
//    }


    ;
}
