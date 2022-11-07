package com.revhalisi.appchurch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revhalisi.appchurch.calender.CalenderActivity;

public class SchedulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shedules);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.schedules);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.schedules:
                        return true;

                    case R.id.profile:
                        startActivity(
                                new Intent(getApplicationContext(), ProfileActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish(); // do something here
                        return true;
                    case R.id.calender:
                        startActivity(
                                new Intent(getApplicationContext(), CalenderActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish(); // do something here
                        return true;
                    case R.id.home:
                        startActivity(
                                new Intent(getApplicationContext(), HomeActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish();// do something here
                        return true;
                    default:
                        return true;
                }
            }
        });

    }
}