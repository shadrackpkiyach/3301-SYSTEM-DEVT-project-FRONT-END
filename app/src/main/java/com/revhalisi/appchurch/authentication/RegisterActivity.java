package com.revhalisi.appchurch.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.revhalisi.appchurch.ProfileActivity;
import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.VerificationPage;
import com.revhalisi.appchurch.api.RetrofitClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.jar.Attributes;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
     public EditText nameText , phoneNumberText ,emailAddressText, passwordText , confirmPassword;
    String codeNumber = "+254";

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

        phoneNumberText.setText("+254");

        String phoneNo = phoneNumberText.getText().toString();
        phoneNumberText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // check if the phone number starts with the code number
                if (!s.toString().startsWith(codeNumber)) {
                    // the phone number does not start with the code number, so display an error
                    phoneNumberText.setError("Phone number must start with " + codeNumber);
                }
            }

            // other methods of the TextWatcher interface, which you can leave empty
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {

                int count = s.length();
                if (count < 13) {
                    phoneNumberText.setError("incomplete Phone number " ); // Show an error message indicating that the count is too low
                } else if (count > 13) {
                    phoneNumberText.setError("exceeds the required Phone number " ); // Show an error message indicating that the count is too high
                }
            }
        });


    }

    private void RegisterUser(){
        HashMap<String, String> map= new HashMap<>();
        map.put("name", nameText.getText().toString());
        map.put("email", emailAddressText.getText().toString());
        map.put("phoneNumber", phoneNumberText.getText().toString());
        map.put("password", passwordText.getText().toString());


        Intent intent = new Intent(RegisterActivity.this, VerificationPage.class);

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
                       intent.putExtra("phoneNumber", phoneNumberText.getText().toString());
                       startActivity(intent);
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

