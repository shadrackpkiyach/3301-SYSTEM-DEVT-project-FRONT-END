package com.revhalisi.appchurch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.revhalisi.appchurch.api.RetrofitClient;
import com.revhalisi.appchurch.authentication.LoginActivity;
import com.revhalisi.appchurch.authentication.RegisterActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerificationPage extends AppCompatActivity implements View.OnClickListener  {
    private EditText codeText;
    private TextView phoneN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);
        codeText = findViewById(R.id.codeVerify);
        phoneN= findViewById(R.id.phoneVerification);
        findViewById(R.id.verificationButton).setOnClickListener(this);

        String phoneNo = getIntent().getStringExtra("phoneNumber");
        phoneN.setText(phoneNo);
    }



    private void verifyUser() {
        HashMap<String, String> map= new HashMap<>();
        map.put("otp", codeText.getText().toString());

        map.put("phoneNumber", phoneN.getText().toString());


        Call<Void> call = RetrofitClient
                .getInstance()
                .getAuthApi()
                .veryfyPhone(map);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200) {
                    Toast.makeText(VerificationPage.this,
                            "code verification successful ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(VerificationPage.this, LoginActivity.class));
                } else if (response.code() == 400) {
                    Toast.makeText(VerificationPage.this,
                            "incorrect code try again", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(VerificationPage.this, t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.verificationButton:
                verifyUser();
                break;
        }}

}