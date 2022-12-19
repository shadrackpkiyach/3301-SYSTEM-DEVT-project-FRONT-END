package com.revhalisi.appchurch.api;

import com.revhalisi.appchurch.api.models.LoginResult;
import com.revhalisi.appchurch.api.models.MembersModels;
import com.revhalisi.appchurch.api.models.PostModels;
import com.revhalisi.appchurch.api.models.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {


    @POST("/loginUser")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/registerUser")
    Call<Void> executeSignup (@Body HashMap<String, String> map);

    @POST("/addPost")
    Call<Void> executePostData (@Body HashMap<String, String> map);
    @GET("/postInformation")
    Call<List<PostModels>>getPosts();

    @GET("/postMembers")
    Call<List<MembersModels>>getMembers();

     @GET("/postProfileData")
    Call<User>getUser();

    @POST("/verifyUser")
    Call<Void> veryfyPhone (@Body HashMap<String, String> map);
}
