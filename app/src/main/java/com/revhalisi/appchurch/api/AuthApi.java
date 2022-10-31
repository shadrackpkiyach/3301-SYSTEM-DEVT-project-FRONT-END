package com.revhalisi.appchurch.api;

import com.revhalisi.appchurch.api.models.LoginResult;
import com.revhalisi.appchurch.api.models.PostModels;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthApi {


    @POST("/loginUser")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/registerUser")
    Call<Void> executeSignup (@Body HashMap<String, String> map);

    @POST("/addPost")
    Call<Void> executePostData (@Body HashMap<String, String> map);
    @GET("/postInformation")
    Call<List<PostModels>>getPosts();

}
