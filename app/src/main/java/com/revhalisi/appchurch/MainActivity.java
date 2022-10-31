package com.revhalisi.appchurch;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revhalisi.appchurch.api.RetrofitInterface;
import com.revhalisi.appchurch.calender.CalenderActivity;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

 bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(
                                new Intent(getApplicationContext(), HomeActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        // do something here
                        return true;

                    case R.id.schedules:
                        startActivity(
                                new Intent(getApplicationContext(), SchedulesActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        // do something here
                        return true;
                    case R.id.calender:
                        startActivity(
                                new Intent(getApplicationContext(), CalenderActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        // do something here
                        return true;
                    case R.id.profile:
                        startActivity(
                                new Intent(getApplicationContext(), ProfileActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        // do something here
                        return true;
                    default:
                        return true;
                }
            }
        });
    }
    }
