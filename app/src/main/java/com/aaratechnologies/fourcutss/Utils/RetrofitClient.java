package com.aaratechnologies.fourcutss.Utils;
import com.aaratechnologies.fourcutss.Utils.Util.ApplicationConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;

    private RetrofitClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(ApplicationConstant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mInstance==null){
            mInstance=new RetrofitClient();
        }
        return mInstance;
    }
    public static GetDataServices getDataServices()
    {
        return retrofit.create(GetDataServices.class);
    }
}