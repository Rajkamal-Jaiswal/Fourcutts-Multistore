package com.aaratechnologies.fourcutss.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.aaratechnologies.fourcutss.Models.ModelUser;
import com.aaratechnologies.fourcutss.R;
import com.aaratechnologies.fourcutss.Utils.SharedPreferenceUser;
import com.aaratechnologies.fourcutss.Utils.Util.M;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        ModelUser modelUser = SharedPreferenceUser.getInstance(getApplicationContext()).getUser();

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(SplashScreen.this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.d("newToken", "Toaken is:   " + newToken);
                M.setToken(newToken, getApplicationContext());


            }
        });
        Log.d("TAG", "onCreate: 0" + modelUser.getMobile());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPreferenceUser.getInstance(getApplicationContext()).isLoggedIn()) {
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                } else {
                    Intent mainIntent = new Intent(getApplicationContext(), WelcomeAcitvity.class);
                    startActivity(mainIntent);
                    finish();
                }
//
            }
        }, 1500);
    }
}