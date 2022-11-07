package com.revhalisi.appchurch.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.revhalisi.appchurch.HomeActivity;
import com.revhalisi.appchurch.MainActivity;
import com.revhalisi.appchurch.ProfileActivity;
import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.api.RetrofitClient;
import com.revhalisi.appchurch.api.models.LoginResult;
import com.revhalisi.appchurch.api.models.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
  private EditText phoneNumberText ,passwordText;
  private Spinner spinner;
  public  static  final  String SHARED_PREFS = "sharedPrefs";
    public  static  final  String USED_PHONE_NUMBER = "UsedPhoneNumber";
    public  static  final  String USED_PASSWORD = "UsedPassword";

  private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneNumberText = findViewById(R.id.inputPhoneNumber);
        passwordText = findViewById(R.id.inputPassword);
        spinner = findViewById(R.id.spinner);
        buttonLogout= findViewById(R.id.logout);
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.toRegister).setOnClickListener(this);
        ArrayAdapter <CharSequence> adapter =ArrayAdapter.createFromResource(this,
                R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




    }

    private void LoginUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("phoneNumber", phoneNumberText.getText().toString());
        map.put("password", passwordText.getText().toString());
         map.put("type",spinner.getSelectedItem().toString());



        Call<LoginResult> call = RetrofitClient
                .getInstance().getAuthApi().executeLogin(map);

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                if (response.code() == 200 && spinner.getSelectedItem().toString().equals("user") )  {

                    LoginResult result = response.body();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    saveData();



                }else if(response.code() == 200 && spinner.getSelectedItem().toString().equals("admin") )  {

                    LoginResult result = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));



                } else if (response.code() == 400) {
                    Toast.makeText(LoginActivity.this, "Wrong Credentials",
                            Toast.LENGTH_LONG).show();
                }

            }

            private void saveData() {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USED_PHONE_NUMBER,phoneNumberText.getText().toString());
                editor.putString(USED_PASSWORD,passwordText.getText().toString());
                editor.apply();

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