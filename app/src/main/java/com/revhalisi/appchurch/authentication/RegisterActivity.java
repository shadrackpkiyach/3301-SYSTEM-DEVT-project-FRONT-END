package com.revhalisi.appchurch.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.revhalisi.appchurch.ProfileActivity;
import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.api.RetrofitClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.jar.Attributes;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
     private EditText nameText , phoneNumberText ,emailAddressText, passwordText , confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameText = findViewById(R.id.inputName);
        emailAddressText = findViewById(R.id.inputREmail);

        passwordText = findViewById(R.id.inputRPassword);
        phoneNumberText = findViewById(R.id.inputRPhoneNumber);
        confirmPassword = findViewById(R.id.inputCRPassword);
        findViewById(R.id.RegisterButton).setOnClickListener(this);
         findViewById(R.id.toLogin).setOnClickListener(this);
    }

    private void RegisterUser(){
        HashMap<String, String> map= new HashMap<>();
        map.put("name", nameText.getText().toString());
        map.put("email", emailAddressText.getText().toString());
        map.put("phoneNumber", phoneNumberText.getText().toString());
        map.put("password", passwordText.getText().toString());

        Call<Void> call = RetrofitClient
                .getInstance()
                .getAuthApi()
                .executeSignup(map);

           call.enqueue(new Callback<Void>() {
               @Override
               public void onResponse(Call<Void> call, Response<Void> response) {
                   if (response.code() == 200) {
                       Toast.makeText(RegisterActivity.this,
                               "Signed up successfully  you can log in ", Toast.LENGTH_LONG).show();
                       startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                   } else if (response.code() == 400) {
                       Toast.makeText(RegisterActivity.this,
                               "Already registered", Toast.LENGTH_LONG).show();
                   }

               }

               @Override
               public void onFailure(Call<Void> call, Throwable t) {
                   Toast.makeText(RegisterActivity.this, t.getMessage(),
                           Toast.LENGTH_LONG).show();
               }
           });
    }

    private  void ToLogin(){
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.RegisterButton:
                RegisterUser();
                break;
            case  R.id.toLogin:
                ToLogin();

                break;
        }}
}