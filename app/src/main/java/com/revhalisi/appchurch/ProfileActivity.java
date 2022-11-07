package com.revhalisi.appchurch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.revhalisi.appchurch.calender.CalenderActivity;
import com.revhalisi.appchurch.profileFraments.AboutFragment;
import com.revhalisi.appchurch.profileFraments.AccountFragment;
import com.revhalisi.appchurch.profileFraments.MembersFragment;
import com.revhalisi.appchurch.profileFraments.NotificationFragment;
import com.revhalisi.appchurch.profileFraments.ShareFragment;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null){
        setContentView(R.layout.activity_profile);}
        Button buttonNotification= findViewById(R.id.notifications);
        Button buttonAccount= findViewById(R.id.Account);
        Button buttonShare= findViewById(R.id.share);
        Button buttonMembers= findViewById(R.id.members);
        Button buttonAbout= findViewById(R.id.about);
       View container= findViewById(R.id.containFragments);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(
                                new Intent(getApplicationContext(), ProfileActivity.class));
                        finish();
                        return true;

                    case R.id.schedules:
                        startActivity(
                                new Intent(getApplicationContext(), SchedulesActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish();
                        // do something here
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
                        finish(); // do something here
                        return true;
                    default:
                        return true;
                }
            }
        });
        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              buttonNotification.setVisibility(View.GONE);
                buttonAccount.setVisibility(View.GONE);
                buttonAbout.setVisibility(View.GONE);
                buttonMembers.setVisibility(View.GONE);
                buttonShare.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containFragments, NotificationFragment.class,null).addToBackStack(String.valueOf(ProfileActivity.class)).commit();

            }
        });
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    buttonNotification.setVisibility(View.GONE);
                    buttonAccount.setVisibility(View.GONE);
                    buttonAbout.setVisibility(View.GONE);
                    buttonMembers.setVisibility(View.GONE);
                    buttonShare.setVisibility(View.GONE);


                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containFragments,AccountFragment.class,null).commit();

            }
        });
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNotification.setVisibility(View.GONE);
                buttonAccount.setVisibility(View.GONE);
                buttonAbout.setVisibility(View.GONE);
                buttonMembers.setVisibility(View.GONE);
                buttonShare.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containFragments, AboutFragment.class,null).commit();

            }
        });
        buttonMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNotification.setVisibility(View.GONE);
                buttonAccount.setVisibility(View.GONE);
                buttonAbout.setVisibility(View.GONE);
                buttonMembers.setVisibility(View.GONE);
                buttonShare.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containFragments, MembersFragment.class,null).commit();

            }
        });
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNotification.setVisibility(View.GONE);
                buttonAccount.setVisibility(View.GONE);
                buttonAbout.setVisibility(View.GONE);
                buttonMembers.setVisibility(View.GONE);
                buttonShare.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containFragments, ShareFragment.class,null).commit();

            }
        });




    }
    @Override
    public void onBackPressed() {
        if (findViewById(R.id.containFragments)==null)
        {
            finish();
        }
        else
        {
            startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));

          //  setContentView  (R.layout.activity_profile);

        }
    }}



