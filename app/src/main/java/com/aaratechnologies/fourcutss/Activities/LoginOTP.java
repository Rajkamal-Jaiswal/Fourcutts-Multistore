package com.aaratechnologies.fourcutss.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aaratechnologies.fourcutss.Models.ModelUser;
import com.aaratechnologies.fourcutss.R;
import com.aaratechnologies.fourcutss.Utils.SharedPreferenceUser;
import com.aaratechnologies.fourcutss.Utils.Util.M;
import com.aaratechnologies.fourcutss.Utils.UtilMethods;
import com.goodiebag.pinview.Pinview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginOTP extends AppCompatActivity {

    Pinview otp_field;
    String data,mobileNo="";
    Button verify;
    TextView txt_timer;
    RelativeLayout relative_ResendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_o_t_p);
        otp_field = findViewById(R.id.otp_field);
        verify = findViewById(R.id.btn_verify);
        txt_timer = findViewById(R.id.txt_timer);
        relative_ResendOtp = findViewById(R.id.relative_ResendOtp);

        data = getIntent().getStringExtra("data");
        mobileNo=getIntent().getStringExtra("mobileNo");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otp_field.getValue().toString().isEmpty()) {
                    Toast.makeText(LoginOTP.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                }
                hitApi(otp_field.getValue().trim());
            }
        });

        getCountDownTimer();

        relative_ResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mobileNo.isEmpty()|| mobileNo.equals("")) {
                    Toast.makeText(LoginOTP.this, "Mobile number can't be Empty", Toast.LENGTH_SHORT).show();
                }
                resendOtp(mobileNo, M.getToken(LoginOTP.this));
            }
        });
    }

    private void getCountDownTimer() {
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                txt_timer.setText(millisUntilFinished / 1000+"Seconds");
                txt_timer.setVisibility(View.VISIBLE);
                verify.setVisibility(View.VISIBLE);
                relative_ResendOtp.setVisibility(View.GONE);
            }
            public void onFinish() {
                relative_ResendOtp.setVisibility(View.VISIBLE);
                txt_timer.setVisibility(View.GONE);
                verify.setVisibility(View.GONE);
            }
        }.start();
    }

    private void resendOtp(String mobileNo, String token) {
        M.showLoadingDialog(LoginOTP.this);
        UtilMethods.
                LoginService(LoginOTP.this, mobileNo, M.getToken(LoginOTP.this),
                        new UtilMethods.ApiCallBackTwoMethod() {
                            @Override
                            public void onSucess(Object object) throws JSONException {
                                M.hideLoadingDialog();
                                Log.d("TAG", "onSucess: " + object);
                                JSONObject jsonObject = new JSONObject(String.valueOf(object));
                                if (jsonObject.getInt("response_code") == 200) {
                                    JSONObject jsonObject1 = jsonObject.getJSONObject("response_data");
                                    String s = jsonObject1.getString("data");
                                    getCountDownTimer();
                                }
                            }

                            @Override
                            public void onError(String errorMsg) {
                                M.hideLoadingDialog();
                                Toast.makeText(LoginOTP.this, "" + errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    private void hitApi(String trim) {
        M.showLoadingDialog(LoginOTP.this);
        UtilMethods.SubmitOtpService(LoginOTP.this, data, trim, M.getToken(LoginOTP.this),
                        new UtilMethods.ApiCallBackTwoMethod() {
                            @Override
                            public void onSucess(Object object) throws JSONException {
                                M.hideLoadingDialog();
                                Log.d("TAG", "onSucess: " + object);
                                JSONObject jsonObject = new JSONObject(String.valueOf(object));
                                if (jsonObject.getInt("response_code") == 200) {
                                    JSONObject jsonObject1 = jsonObject.getJSONObject("response_data");
                                    JSONArray jsonArray = jsonObject1.getJSONArray("data");
                                    if (jsonArray.length() > 0) {
                                        JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                                        String user_id = jsonObject2.getString("user_id");
                                        String user_auth_id = jsonObject2.getString("user_auth_id");
                                        String username = jsonObject2.getString("username");
                                        String email = jsonObject2.getString("email");
                                        String mobile = jsonObject2.getString("mobile");
                                        String meta_values = jsonObject2.getString("meta_values");
                                        String status = jsonObject2.getString("status");
                                        String created_by = jsonObject2.getString("created_by");
                                        String created_at = jsonObject2.getString("created_at");
                                        String image = jsonObject2.getString("image");
                                        String address = jsonObject2.getString("address");
                                        String latitude = jsonObject2.getString("latitude");
                                        String langitude = jsonObject2.getString("langitude");
                                        String city = jsonObject2.getString("city");
                                        String zip = jsonObject2.getString("zip");
                                        String state = jsonObject2.getString("state");
                                        String country = jsonObject2.getString("country");
                                        String user_base_id = jsonObject2.getString("user_base_id");
                                        String otp = jsonObject2.getString("otp");
                                        String email_token = jsonObject2.getString("email_token");
                                        String otp_verified = jsonObject2.getString("otp_verified");
                                        String email_verified = jsonObject2.getString("email_verified");
                                        String session_key = jsonObject2.getString("session_key");
                                        String auth_key = jsonObject2.getString("auth_key");
                                        String password = jsonObject2.getString("password");
                                        String login_time = jsonObject2.getString("login_time");
                                        String logout_time = jsonObject2.getString("logout_time");
                                        String is_login = jsonObject2.getString("is_login");
                                        String device_token = jsonObject2.getString("device_token");
                                        SharedPreferenceUser.getInstance(LoginOTP.this).userLogin(new ModelUser(user_id, user_auth_id, username, email, mobile, meta_values, status, created_by, created_at, image, address, latitude, langitude, city, zip, state, country, user_base_id, otp, email_token, otp_verified, email_verified, session_key, auth_key, password, login_time, logout_time, is_login, device_token));
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                }else {
                                    Toast.makeText(LoginOTP.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onError(String errorMsg) {
                                M.hideLoadingDialog();
                                Toast.makeText(LoginOTP.this, "" + errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });
    }

}