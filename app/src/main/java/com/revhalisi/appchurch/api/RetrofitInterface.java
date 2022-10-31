package com.revhalisi.appchurch.api;
import com.revhalisi.appchurch.authentication.LoginResult2;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/loginUser")
    Call<LoginResult2> executeLogin(@Body HashMap<String, String> map);

    @POST("/registerUser")
    Call<Void> executeSignup (@Body HashMap<String, String> map);

    @POST("/addPost")
    Call<Void> executePostData (@Body HashMap<String, String> map);

}
