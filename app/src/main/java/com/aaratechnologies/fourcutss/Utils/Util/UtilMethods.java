package com.aaratechnologies.fourcutss.Utils.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.aaratechnologies.fourcutss.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//public enum UtilMethods {
//
//    INSTANCE;
//
//    public boolean isValidMobile(String mobile) {
//
//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//        String mobilePattern = "^(?:0091|\\\\+91|0)[7-9][0-9]{9}$";
//        String mobileSecPattern = "[7-9][0-9]{9}$";
//
//        if (mobile.matches(mobilePattern) || mobile.matches(mobileSecPattern)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void dialogOk(final Context context, String title, final String message, final int flag) {
//        try {
//            new AlertDialog.Builder(context)
//                    .setTitle(title)
//                    .setMessage(message)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            // "OK" button was clicked
//
//                        }
//                    })
//                    .show();
//        } catch (Exception e) {
//
//        }
//    }
//
//
//    public interface ApiCallBack {
//        void onSucess(Object object);
//    }
//
//    public interface ApiCallBackTwoMethod {
//        void onSucess(Object object);
//
//        void onError(String errorMsg);
//    }
//
//    public void Error(final Context context, final String message) {
//        if ((message != null && !message.equalsIgnoreCase(""))) {
//            if (message.contains("(redirectToLogin)")) {
//                //   logout(context);
//            } else {
////                CustomAlertDialog customAlertDialog = new CustomAlertDialog(context,true);
////                customAlertDialog.Error(message);
//            }
//        }
//    }
//
//    /*Test Owner*/
//    public void LoginMine(final Context context, String s, String mobile, String token, final ApiCallBackTwoMethod apicallback) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//            Call<ResponseBody> call = git.LoginService(mobile, token);
//            call.enqueue(new Callback<ResponseBody>() {
//                @Override
//                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                    try {
//                        if ((response.body() != null && response.isSuccessful())) {
//                            String s=response.body().toString();
////                            apicallback.onSucess(response.body().string());
//                            Log.d("TAG", "sfsfsdfvsef: "+s);
////                            UtilMethods.INSTANCE.dialogOk(context, context.getString(R.string.successful_title),
////                                    "   "+response.body().getMessage(), 12);
//                            //Toast.makeText(context, "successful title", //Toast.LENGTH_SHORT).show();
//                        } else {
////                             UtilMethods.INSTANCE.Error(context, "  ");
//                            UtilMethods.INSTANCE.dialogOk(context, context.getString(R.string.failed),
//                                    "  " + context.getString(R.string.failed), 12);
//                            apicallback.onError(context.getString(R.string.failed));
//                        }
//
//                    } catch (Exception e) {
//
////                        Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        UtilMethods.INSTANCE.dialogOk(context, context.getString(R.string.alert),
//                                e.getMessage() + "", 2);
//                        UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<ResponseBody> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//           /* if (loader.isShowing())
//                loader.dismiss();*/
//            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//        }
//    }
//    /*Test Ownership close*/
//
////    public void LoginMine(final Context context, String email, String password, String action, final ApiCallBack apiCallBack) {
////        try {
////            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
////
////            Call<LoginResponse> call = git.TestService(new LoginReq(email, password, action));
////
////            call.enqueue(new Callback<LoginResponse>() {
////                @Override
////                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
////                    try {
////                        if ((response.body() != null && response.body().getStatus() != null &&
////                                response.body().getStatus())) {
////                            apiCallBack.onSucess(response.body());
////                            Log.v("vbcvd", "successful title");
//////                            //Toast.makeText(context, "successful title", //Toast.LENGTH_SHORT).show();
////                        } else {
////                            if (response.body() != null && response.body().getLoginRes() != null) {
////
////                            }
////                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                        }
////
////                    } catch (Exception e) {
////
////                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                    }
////                }
////
////                @Override
////                public void onFailure(Call<LoginResponse> call, Throwable t) {
////                    try {
////
////                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
////
////                            if (t.getMessage().contains("No address associated with hostname")) {
////                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
////                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
////                            } else {
////                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
////                                UtilMethods.INSTANCE.Error(context, t.getMessage());
////                            }
////
////                        } else {
////                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                        }
////                    } catch (IllegalStateException ise) {
////
////                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                    }
////
////                }
////            });
////        } catch (Exception e) {
//////            e.printStackTrace();
////            e.printStackTrace();
////           /* if (loader.isShowing())
////                loader.dismiss();*/
////            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
////            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
////
////        }
////
////    }
//
////    public void CateGoryLists(final Context context, String action, final ApiCallBackTwoMethod apiCallBack) {
////        try {
////            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
////
////            Call<CategoryResponse> call = git.CateGoryListService(new CategoryReq(action));
////            call.enqueue(new Callback<CategoryResponse>() {
////                @Override
////                public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
////                    try {
////                        if ((response.body() != null && response.body().getStatus() != null &&
////                                response.body().getStatus())) {
////                            apiCallBack.onSucess(response.body());
////                            Log.v("vbcvd", "successful title");
////                        } else {
////                            if (response.body() != null && response.body().getResult() != null)
////                                apiCallBack.onError(response.body().getMessege());
////                            ////Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                            //
////                            }
////                        }
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                        apiCallBack.onError(response.body().getMessege());
////                        ////Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
////                    }
////                }
////
////                @Override
////                public void onFailure(Call<CategoryResponse> call, Throwable t) {
////                    try {
////
////                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
////
////                            if (t.getMessage().contains("No address associated with hostname")) {
////                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
////                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
////
////
////                            } else {
////                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
////                                UtilMethods.INSTANCE.Error(context, t.getMessage());
////
////
////                            }
////
////                        } else {
////                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                        }
////                    } catch (IllegalStateException ise) {
////
////                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
////                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                    }
////                }
////            });
////        } catch (Exception e) {
////            e.printStackTrace();
////           /* if (loader.isShowing())
////                loader.dismiss();*/
////            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
////            UtilMethods.INSTANCE.Error(context, "Excep: " + e.getMessage() + "");
////
////        }
////
////    }
////
////    public void AdminProductsLists(final Context context, String action, final ApiCallBackTwoMethod apiCallBack) {
////        try {
////            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
////
////            Call<AdminProductListsResponse> call = git.AdminProductLists(new AdminProductReq(action));
////
////            call.enqueue(new Callback<AdminProductListsResponse>() {
////                @Override
////                public void onResponse(Call<AdminProductListsResponse> call, Response<AdminProductListsResponse> response) {
////                    try {
////                        if ((response.body() != null && response.body().getStatus() != null &&
////                                response.body().getStatus())) {
////                            apiCallBack.onSucess(response.body());
////                            Log.v("vbcvd", "successful title");
////                            //                            //Toast.makeText(context, "successful title", //Toast.LENGTH_SHORT).show();
////                            //                        }
////                        } else {
////                            if (response.body() != null && response.body().getResult() != null)
////                                apiCallBack.onError(response.body().getMessege());
////                            //                        }
////                        }
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
////                    }
////                }
////
////                @Override
////                public void onFailure(Call<AdminProductListsResponse> call, Throwable t) {
////                    try {
////
////                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
////
////                            if (t.getMessage().contains("No address associated with hostname")) {
////                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
////                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
////
////
////                            } else {
////                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
////                                UtilMethods.INSTANCE.Error(context, t.getMessage());
////
////
////                            }
////
////                        } else {
////                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
////                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                        }
////                    } catch (IllegalStateException ise) {
////
////                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
////                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
////                    }
////                }
////            });
////        } catch (Exception e) {
////            e.printStackTrace();
////           /* if (loader.isShowing())
////                loader.dismiss();*/
////            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
////            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
////        }
////    }
////
////    public void CategoryWiseProductLists(final Context context, String categoryId, final ApiCallBackTwoMethod apiCallBack) {
////
////        try {
////            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
////
////            Call<CatWiseProductResponse> call = git.CategoryWiseProductLists(new CatWiseProductReq(categoryId));
////
//            call.enqueue(new Callback<CatWiseProductResponse>() {
//                @Override
//                public void onResponse(Call<CatWiseProductResponse> call, Response<CatWiseProductResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBack.onSucess(response.body());
//                        } else {
//                            if (response.body() != null && response.body().getResult() != null)
//                                //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                                apiCallBack.onError(response.body().getMessege());
//                            UtilMethods.INSTANCE.Error(context, response.body().getMessege());
//                            //                        }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
////                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<CatWiseProductResponse> call, Throwable t) {
//                    try {
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//                            if (t.getMessage().contains("No address associated with hostname")) {
////                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//                            }
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//           /* if (loader.isShowing())
//                loader.dismiss();*/
//            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//        }
//
//    }
//
//    public void ProductShowsService(final Context context, String ProductId, final ApiCallBackTwoMethod apiCallBackTwoMethod)
//
//    {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//            Call<ProductShowResponse> call = git.ProductShowAllDetails(new ProductShowReq(ProductId));
//            call.enqueue(new Callback<ProductShowResponse>() {
//                @Override
//                public void onResponse(Call<ProductShowResponse> call, Response<ProductShowResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBackTwoMethod.onSucess(response.body());
//                        } else {
//                            if (response.body() != null && response.body().getResult() != null)
//                                //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                                apiCallBackTwoMethod.onError(response.body().getMessege());
//                            UtilMethods.INSTANCE.Error(context, response.body().getMessege());
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ProductShowResponse> call, Throwable t) {
//                    try {
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//                            }
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//        }
//    }
//
//    public void ShowVendorsListService(final Context context, String action, final ApiCallBackTwoMethod apiCallBackTwoMethod) {
//        EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//        Call<VendorListResponse> call = git.VendorDetailsLists(new VendorListReq(action));
//        call.enqueue(new Callback<VendorListResponse>() {
//            @Override
//            public void onResponse(Call<VendorListResponse> call, Response<VendorListResponse> response) {
//                try {
//                    if ((response.body() != null && response.body().getStatus() != null &&
//                            response.body().getStatus())) {
//                        apiCallBackTwoMethod.onSucess(response.body());
//                    } else {
//                        if (response.body() != null && response.body().getResult() != null)
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            apiCallBackTwoMethod.onError(response.body().getMessege());
//                        UtilMethods.INSTANCE.Error(context, response.body().getMessege());
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<VendorListResponse> call, Throwable t) {
//                try {
//                    if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//                        if (t.getMessage().contains("No address associated with hostname")) {
//                            //                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//                        } else {
//                            // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                            UtilMethods.INSTANCE.Error(context, t.getMessage());
//                        }
//                    } else {
//                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                } catch (IllegalStateException ise) {
//                    //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                }
//            }
//        });
//    }
//
//    public void AddToCartApiServices(final Context context, String Productid, String customercode, String qty, final ApiCallBackTwoMethod apiCallBack) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Call<AddToCartResponse> call = git.AddToCartServie(new AddToCartReq(Productid, customercode, qty));
//
//            call.enqueue(new Callback<AddToCartResponse>() {
//                @Override
//                public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBack.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
////                            //Toast.makeText(context, "successful title", //Toast.LENGTH_SHORT).show();
//                        } else {
//                            if (response.body() != null && response.body().getAddToCartRes() != null)
//                                apiCallBack.onError("Failed: " + response.errorBody());
////                                //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        }
//
//                    } catch (Exception e) {
//
//                        //Toast.makeText(context, "Failed: "+e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<AddToCartResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed Error", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed"+ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//
//                }
//            });
//        } catch (Exception e) {
////            e.printStackTrace();
//            e.printStackTrace();
//           /* if (loader.isShowing())
//                loader.dismiss();*/
//            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//
//        }
//
//    }
//
//    public void DeleteCart(final Context context, String Productid, String customercode, final ApiCallBackTwoMethod apiCallBack) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Log.d("h2", "DeleteCart: " + Productid);
//            Call<DeleteCartResponse> call = git.DeleteCartService(new CartDeleteReq(Productid, customercode));
//
//            call.enqueue(new Callback<DeleteCartResponse>() {
//                @Override
//                public void onResponse(Call<DeleteCartResponse> call, Response<DeleteCartResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBack.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
////                            //Toast.makeText(context, "successful title", //Toast.LENGTH_SHORT).show();
//                        } else {
//                            if (response.body() != null && response.body().getMessage() != null)
//                                apiCallBack.onError("Failed");
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        }
//
//                    } catch (Exception e) {
//
//                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<DeleteCartResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//
//                }
//            });
//        } catch (Exception e) {
////            e.printStackTrace();
//            e.printStackTrace();
//           /* if (loader.isShowing())
//                loader.dismiss();*/
//            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//
//        }
//
//    }
//
//    public void ShorCartData(final Context context, String custId, final ApiCallBackTwoMethod apiCallBack) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Call<ShowCartDataResponse> call = git.ShowCartDataService(new ShowCartDetailsReq(custId));
//
//            call.enqueue(new Callback<ShowCartDataResponse>() {
//                @Override
//                public void onResponse(Call<ShowCartDataResponse> call, Response<ShowCartDataResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBack.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
//
//                        } else {
//                            if (response.body() != null && response.body().getResult() != null)
//                                apiCallBack.onError(response.body().getMessege());
//                            //                        }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ShowCartDataResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//
//
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//           /* if (loader.isShowing())
//                loader.dismiss();*/
//            // //Toast.makeText(context, "uiofdshuhfjsdds", //Toast.LENGTH_SHORT).show();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//        }
//    }
//
//    public void RegisterUser(final Context context, String CustomerName, String EmailAddress, String MobileNumber, String Password, final ApiCallBackTwoMethod apiCallBackTwoMethod) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Call<RegisterResponse> call = git.showRegistrationService(new RegisterReq(CustomerName, EmailAddress, MobileNumber, Password));
//            call.enqueue(new Callback<RegisterResponse>() {
//                @Override
//                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBackTwoMethod.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
//
//                        } else {
//                            if (response.body() != null && response.body().getMessage() != null)
//                                apiCallBackTwoMethod.onError(response.body().getMessage());
//                            //                        }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//
//
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void placeOrder(final Context context, String Addresstype, String Customerid, String Locality, String Pincode, String ProductId, String Quantity, String TotalAmount,
//                           String address, String addressid, String city, String deliverycharge, String deliverytype, String landmark,
//                           String paymentmethod, String paymentmode, String state, String subtotal, String table_OrderItems,
//                           String totalpaidamt, String zoneid, final ApiCallBackTwoMethod apiCallBackTwoMethod) {
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Call<PlaceOrderResponse> call = git.placeOrderService(new PlaceOrderReq(Addresstype, Customerid, Locality, Pincode,
//                    ProductId, Quantity, TotalAmount, address, addressid, city, deliverycharge, deliverytype, landmark, paymentmethod, paymentmode, state,
//                    subtotal, table_OrderItems, totalpaidamt, zoneid));
//            call.enqueue(new Callback<PlaceOrderResponse>() {
//                @Override
//                public void onResponse(Call<PlaceOrderResponse> call, Response<PlaceOrderResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBackTwoMethod.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
//
//                        } else {
//                            if (response.body() != null && response.body().getMessage() != null)
//                                apiCallBackTwoMethod.onError(response.body().getMessage());
//                            //                        }
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<PlaceOrderResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void ShowOrderHistory(final Context context, String customerid, final ApiCallBackTwoMethod apiCallBack) {
//
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//
//            Call<ShowOrderHistoryResponse> call = git.showOrderHistory(new OrderHistoryReq(customerid));
//
//            call.enqueue(new Callback<ShowOrderHistoryResponse>() {
//                @Override
//                public void onResponse(Call<ShowOrderHistoryResponse> call, Response<ShowOrderHistoryResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBack.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
//
//                        } else {
//                            if (response.body() != null && response.body().getResult() != null)
//                                apiCallBack.onError(response.body().getMessege());
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ShowOrderHistoryResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//
//
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//            UtilMethods.INSTANCE.Error(context, e.getMessage() + "");
//        }
//
//
//    }
//
//    public void showBannerListGetData(final  Context context,final ApiCallBackTwoMethod apiCallBackTwoMethod){
//        try {
//            EndPointInterface git = ApiClient.getClient().create(EndPointInterface.class);
//            Call<BannerResponse> call = git.showBannerList(new BannerReq());
//
//            call.enqueue(new Callback<BannerResponse>() {
//                @Override
//                public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
//                    try {
//                        if ((response.body() != null && response.body().getStatus() != null &&
//                                response.body().getStatus())) {
//                            apiCallBackTwoMethod.onSucess(response.body());
//                            Log.v("vbcvd", "successful title");
//
//                        } else {
//                            if (response.body() != null && response.body().getResult() != null)
//                                apiCallBackTwoMethod.onError(response.body().getMessege());
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //Toast.makeText(context, "Failed:" + e.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<BannerResponse> call, Throwable t) {
//                    try {
//
//                        if (t.getMessage() != null && !t.getMessage().isEmpty()) {
//                            if (t.getMessage().contains("No address associated with hostname")) {
//                                //Toast.makeText(context, "hehehehehe", //Toast.LENGTH_SHORT).show();
//                                //                                UtilMethods.INSTANCE.Error(context, context.getString(R.string.err_msg_network));
//
//
//                            } else {
//                                // //Toast.makeText(context, "ohoohoh", //Toast.LENGTH_SHORT).show();
//                                UtilMethods.INSTANCE.Error(context, t.getMessage());
//
//
//                            }
//
//                        } else {
//                            //Toast.makeText(context, "Failed", //Toast.LENGTH_SHORT).show();
//                            //                            UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                        }
//                    } catch (IllegalStateException ise) {
//
//                        //Toast.makeText(context, "Failed: " + ise.getLocalizedMessage(), //Toast.LENGTH_SHORT).show();
//                        //                        UtilMethods.INSTANCE.Error(context, context.getString(R.string.failed));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}