package com.revhalisi.appchurch.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private  final Retrofit retrofit;
    private static RetrofitClient mInstance;
    private static final String BASE_URL = "http://10.0.2.2:3000/";

    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;

    }
    public AuthApi getAuthApi(){
        return  retrofit.create(AuthApi.class);
    }
}
