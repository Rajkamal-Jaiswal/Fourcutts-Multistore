package com.aaratechnologies.fourcutss.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UtilMethods {


    public interface ApiCallBack {
        void onSucess(Object object);
    }

    public interface ApiCallBackTwoMethod {
        void onSucess(Object object) throws JSONException;

        void onError(String errorMsg);
    }

//    public void dialogOk(final Context context, String title, final String message, final int flag) {
//        try {
//            new AlertDialog.Builder(context)
//                    .setTitle(title)
//                    .setMessage(message)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // "OK" button was clicked
//                            dialogInterface.dismiss();
//
//                        }
//                    })
//                    .show();
//        } catch (Exception e) {
//
//        }
//    }
//

    public static void LoginService(final Context context, String mobile,String token, final ApiCallBackTwoMethod apiCallBack) {
        Call<ResponseBody> bodyCall = RetrofitClient.getInstance().getDataServices().userLogin(mobile,token);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = null;
                if (response.isSuccessful()) {
                    try {
                        s = response.body().string();
                        Log.d("TAG", "xfeffffe: "+s);
                        apiCallBack.onSucess(s);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                   dialogOk(context,"Alert ! ","Error: "+response.errorBody().toString(),1);
                    Log.d("ss", "onResponse: "+response.errorBody());
                    apiCallBack.onError("No record found");
                }
            }

//                        Log.d("enquiry", "onResponse: " + s);
//                        JSONObject jsonObject = new JSONObject(s);
//                        if (jsonObject.getInt("response_code") == 200) {
//                            JSONObject jsonObject1 = jsonObject.getJSONObject("response_data");
//                            JSONArray jsonArray = jsonObject1.getJSONArray("data");
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                                String shop_id = jsonObject2.getString("shop_id");
//                                String role_id = jsonObject2.getString("role_id");
//                                String mega_type_id = jsonObject2.getString("mega_type_id");
//                                String vendor_id = jsonObject2.getString("vendor_id");
//                                String shop_owner = jsonObject2.getString("shop_owner");
//                                String shop_mobile = jsonObject2.getString("shop_mobile");
//                                String shop_address = jsonObject2.getString("shop_address");
//                                String shop_landmark = jsonObject2.getString("shop_landmark");
//                                String shop_latitude = jsonObject2.getString("shop_latitude");
//                                String shop_longitude = jsonObject2.getString("shop_longitude");
//                                String shop_holiday = jsonObject2.getString("shop_holiday");
//                                String shop_image = jsonObject2.getString("shop_image");
//                                String shop_city = jsonObject2.getString("shop_city");
//                                String shop_state = jsonObject2.getString("shop_state");
//                                String shop_country = jsonObject2.getString("shop_country");
//                                String shop_pin = jsonObject2.getString("shop_pin");
//                                String shop_registration_type = jsonObject2.getString("shop_registration_type");
//                                String shop_gst = jsonObject2.getString("shop_gst");
//                                String shop_adhar = jsonObject2.getString("shop_adhar");
//                                String shop_registrion_no = jsonObject2.getString("shop_registrion_no");
//                                String shop_status = jsonObject2.getString("shop_status");
//                                String shop_unicode = jsonObject2.getString("shop_unicode");
//                                String shop_website = jsonObject2.getString("shop_website");
//                                String plans_id = jsonObject2.getString("plans_id");
//                                String username = jsonObject2.getString("username");
//                                String email = jsonObject2.getString("email");
//                                String password = jsonObject2.getString("password");
//                                String brand_id = jsonObject2.getString("brand_id");
//                                String brand_name = jsonObject2.getString("brand_name");
//                                String brand_image = jsonObject2.getString("brand_image");
//                                String brand_category = jsonObject2.getString("brand_category");
//                                String status_brand = jsonObject2.getString("status_brand");
//                                MasterSellerStorage.getInstance(getApplicationContext()).setData(MasterSellerDetailsApi(shop_id, role_id, mega_type_id, vendor_id, shop_owner, shop_mobile, shop_address, shop_landmark, shop_latitude, shop_longitude, shop_holiday, shop_image, shop_city, shop_state, shop_country, shop_pin, shop_registration_type, shop_gst, shop_adhar, shop_registrion_no, shop_status, shop_unicode, shop_website, plans_id, username, email, password, brand_id, brand_name, brand_image, brand_category,
//                                        status_brand));
//                            }

//                        } else {
////                            Toast.makeText(MegaSellerDashboard.this, "" + jsonObject.getString("comments"), Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (IOException | JSONException e) {
//                        Log.d("enquiry", "Excep: " + e.getLocalizedMessage());
//                        e.printStackTrace();
//                    }

//                }
//            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                apiCallBack.onError("No record found "+t.getLocalizedMessage());
                Log.d("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private static void dialogOk(final Context context, String title, final String message, final int flag) {
        try {
            new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // "OK" button was clicked
                            dialogInterface.dismiss();

                        }
                    })
                    .show();
        } catch (Exception e) {

        }
    }

    public static void SubmitOtpService(final  Context context,String user_id,String otp,String device_token,final ApiCallBackTwoMethod  apiCallBackTwoMethod){
        Call<ResponseBody> bodyCall = RetrofitClient.getInstance().getDataServices().sendOPtpHere(user_id,otp,device_token);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s = null;
                if (response.code() == 200) {
                    try {
                        s = response.body().string();
                        Log.d("sdfghjkl", "onResponse: "+s);
                        apiCallBackTwoMethod.onSucess(s);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    apiCallBackTwoMethod.onError("No record found");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                apiCallBackTwoMethod.onError("No record found");
            }
        });

    }
}