package com.revhalisi.appchurch.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.revhalisi.appchurch.HomeActivity;
import com.revhalisi.appchurch.MainActivity;
import com.revhalisi.appchurch.ProfileActivity;
import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.api.RetrofitClient;
import com.revhalisi.appchurch.api.models.LoginResult;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
  private EditText phoneNumberText ,passwordText;
  private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneNumberText = findViewById(R.id.inputPhoneNumber);
        passwordText = findViewById(R.id.inputPassword);
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.toRegister).setOnClickListener(this);
    }

    private void LoginUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("phoneNumber", phoneNumberText.getText().toString());
        map.put("password", passwordText.getText().toString());

        Call<LoginResult> call = RetrofitClient
                .getInstance().getAuthApi().executeLogin(map);

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                if (response.code() == 200) {

                    LoginResult result = response.body();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));



                } else if (response.code() == 400) {
                    Toast.makeText(LoginActivity.this, "Wrong Credentials",
                            Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private  void ToRegistration(){
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.loginButton:
                LoginUser();
                break;
            case  R.id.toRegister:
                ToRegistration();

                break;
    }}
}