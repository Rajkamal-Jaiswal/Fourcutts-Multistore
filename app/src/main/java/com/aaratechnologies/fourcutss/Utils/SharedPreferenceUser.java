package com.aaratechnologies.fourcutss.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.aaratechnologies.fourcutss.Models.ModelUser;

public class SharedPreferenceUser {

    private static final String SHARED_PREF_NAME = "Fourcutss_User";
    private static final String user_id = "user_id";
    private static final String user_auth_id = "user_auth_id";
    private static final String username = "username";
    private static final String email = "email";
    private static final String mobile = "mobile";
    private static final String meta_values = "meta_values";
    private static final String status = "status";
    private static final String created_by = "created_by";
    private static final String created_at = "created_at";
    private static final String image = "image";
    private static final String address = "address";
    private static final String latitude = "latitude";
    private static final String langitude = "langitude";
    private static final String city = "city";
    private static final String zip = "zip";
    private static final String state = "state";
    private static final String country = "country";
    private static final String user_base_id = "user_base_id";
    private static final String otp = "otp";
    private static final String email_token = "email_token";
    private static final String otp_verified = "otp_verified";
    private static final String email_verified = "email_verified";
    private static final String session_key = "session_key";
    private static final String auth_key = "auth_key";
    private static final String password = "password";
    private static final String login_time = "login_time";
    private static final String logout_time = "logout_time";
    private static final String is_login = "is_login";
    private static final String device_token = "device_token";
    private static SharedPreferenceUser mInstance;
    private static Context mCtx;

    private SharedPreferenceUser(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPreferenceUser getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPreferenceUser(context);
        }
        return mInstance;
    }

    public void userLogin(ModelUser user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_id", user.getUser_id());
        editor.putString("user_auth_id", user.getUser_auth_id());
        editor.putString("username", user.getUsername());
        editor.putString("email", user.getEmail());
        editor.putString("mobile", user.getMobile());
        editor.putString("meta_values", user.getMeta_values());
        editor.putString("status", user.getStatus());
        editor.putString("created_by", user.getCreated_by());
        editor.putString("created_at", user.getCreated_at());
        editor.putString("image", user.getImage());
        editor.putString("address", user.getAddress());
        editor.putString("latitude", user.getLangitude());
        editor.putString("langitude", user.getLangitude());
        editor.putString("city", user.getCity());
        editor.putString("zip", user.getZip());
        editor.putString("state", user.getState());
        editor.putString("country", user.getCountry());
        editor.putString("user_base_id", user.getUser_base_id());
        editor.putString("otp", user.getOtp());
        editor.putString("email_token", user.getEmail_token());
        editor.putString("otp_verified", user.getOtp_verified());
        editor.putString("email_verified", user.getEmail_verified());
        editor.putString("session_key", user.getSession_key());
        editor.putString("auth_key", user.getAuth_key());
        editor.putString("password", user.getPassword());
        editor.putString("login_time", user.getLogin_time());
        editor.putString("logout_time", user.getLogout_time());
        editor.putString("is_login", user.getIs_login());
        editor.putString("device_token", user.getDevice_token());
        editor.apply();
        editor.commit();

    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("mobile", null) != null;
    }

    public ModelUser getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new ModelUser(
                sharedPreferences.getString(user_id, null),
                sharedPreferences.getString(user_auth_id, null),
                sharedPreferences.getString(username, null),
                sharedPreferences.getString(email, null),
                sharedPreferences.getString(mobile, null),
                sharedPreferences.getString(meta_values, null),
                sharedPreferences.getString(status, null),
                sharedPreferences.getString(created_by, null),
                sharedPreferences.getString(created_at, null),
                sharedPreferences.getString(image, null),
                sharedPreferences.getString(address, null),
                sharedPreferences.getString(latitude, null),
                sharedPreferences.getString(langitude, null),
                sharedPreferences.getString(city, null),
                sharedPreferences.getString(zip, null),
                sharedPreferences.getString(state, null),
                sharedPreferences.getString(country, null),
                sharedPreferences.getString(user_base_id, null),
                sharedPreferences.getString(otp, null),
                sharedPreferences.getString(email_token, null),
                sharedPreferences.getString(otp_verified, null),
                sharedPreferences.getString(email_verified, null),
                sharedPreferences.getString(session_key, null),
                sharedPreferences.getString(auth_key, null),
                sharedPreferences.getString(password, null),
                sharedPreferences.getString(login_time, null),
                sharedPreferences.getString(logout_time, null),
                sharedPreferences.getString(is_login, null),
                sharedPreferences.getString(device_token, null)
        );
    }

    //
//
    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

