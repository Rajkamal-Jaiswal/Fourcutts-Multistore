package com.aaratechnologies.fourcutss.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aaratechnologies.fourcutss.R;
import com.aaratechnologies.fourcutss.Utils.Util.M;
import com.aaratechnologies.fourcutss.Utils.UtilMethods;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    String mobile = "", token = "";
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.phone);
    }

    private void hitApi(String mobile, String token) {
        M.showLoadingDialog(LoginActivity.this);
        UtilMethods.
                LoginService(LoginActivity.this, mobile, token,
                        new UtilMethods.ApiCallBackTwoMethod() {
                            @Override
                            public void onSucess(Object object) throws JSONException {
                                M.hideLoadingDialog();
                                Log.d("TAG", "onSucess: " + object);
                                JSONObject jsonObject = new JSONObject(String.valueOf(object));
                                if (jsonObject.getInt("response_code") == 200) {
                                    JSONObject jsonObject1 = jsonObject.getJSONObject("response_data");
                                    String s = jsonObject1.getString("data");
                                    Intent intent = new Intent(getApplicationContext(), LoginOTP.class);
                                    intent.putExtra("data",s);
                                    intent.putExtra("mobileNo",mobile);
                                    startActivity(intent);
                                    finish();
                                }
                            }

                            @Override
                            public void onError(String errorMsg) {
                                M.hideLoadingDialog();
                                Toast.makeText(LoginActivity.this, "" + errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });
    }

    public void GOTODashboard(View view) {
        mobile = phone.getText().toString().trim();
        token=M.getToken(LoginActivity.this);
        if (mobile.isEmpty()) {
            Toast.makeText(this, "Mobile number can't be Empty", Toast.LENGTH_SHORT).show();
            phone.requestFocus();
            return;
        }
        hitApi(mobile, token);
    }
}