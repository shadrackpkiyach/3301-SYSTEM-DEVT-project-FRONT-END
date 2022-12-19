package com.revhalisi.appchurch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.revhalisi.appchurch.api.RetrofitClient;
import com.revhalisi.appchurch.api.models.PostModels;
import com.revhalisi.appchurch.authentication.RegisterActivity;
import com.revhalisi.appchurch.biblePart.MainActivity;
import com.revhalisi.appchurch.calender.CalenderActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     ProgressBar progressBar;
     RecyclerView.Adapter mAdapter;
    LinearLayoutManager layoutManager;
   FloatingActionButton floatingActionButton;
   List<PostModels> postModelsList = new ArrayList<>();
   private EditText editPostText;
   private Button buttonLogout;
   private MenuItem menuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        reminderNotification();
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.homeRecycler) ;
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
         floatingActionButton =  findViewById(R.id.editPost);


        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;

                    case R.id.schedules:
                        startActivity(
                                new Intent(getApplicationContext(), MainActivity.class)

                        );
                        overridePendingTransition(0, 0);
                        // do something here
                        finish();
                        return true;
                    case R.id.calender:
                        startActivity(
                                new Intent(getApplicationContext(), CalenderActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish();
                        // do something here
                        return true;
                    case R.id.profile:
                        startActivity(
                                new Intent(getApplicationContext(), ProfileActivity.class)
                        );
                        overridePendingTransition(0, 0);
                        finish();
                        // do something here
                        return true;
                    default:
                        return true;
                }
            }
        });

        findViewById(R.id.editPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showEditPostDialog();
            }
        });
  // ret = RetrofitClient;

    recyclerView.setHasFixedSize(true);
    layoutManager =new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

   mAdapter = new RecycleViewAdapter(postModelsList,this);
    recyclerView.setAdapter(mAdapter);

    fetchPosts();


    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
                finish();
              return true;
            default:
                return true;
        }
    }





    private void fetchPosts() {
        RetrofitClient.getInstance().getAuthApi().getPosts().enqueue(new Callback<List<PostModels>>() {
            @Override
            public void onResponse(Call<List<PostModels>> call, Response<List<PostModels>> response) {
                if (response.isSuccessful()){
postModelsList.addAll(response.body());
       mAdapter.notifyDataSetChanged();
       progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<List<PostModels>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(HomeActivity.this, t.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });
    }
    public void reminderNotification()
    {
        Notification _notificationUtils = new Notification(this);
        long _currentTime = System.currentTimeMillis();
        long tenSeconds = 1000 * 10;
        long _triggerReminder = _currentTime + tenSeconds; //triggers a reminder after 10 seconds.
        _notificationUtils.setReminder(_triggerReminder);
    }



    private void showEditPostDialog() {
        View view =getLayoutInflater().inflate(R.layout.edit_post_dialog,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();
        TextView postText = view.findViewById(R.id.toPost);
        EditText editPostText = view.findViewById(R.id.editInformation);
        EditText editTitleText = view.findViewById(R.id.editInformationTitle);
        postText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // LoginResult result = response.body();
                HashMap<String, String> map = new HashMap<>();
                map.put("information", editPostText.getText().toString());
                map.put("title",editTitleText.getText().toString());



                Call<Void> call = RetrofitClient
                        .getInstance()
                        .getAuthApi()
                        .executePostData(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == 200) {
                            Toast.makeText(HomeActivity.this,
                                    "Post added successfully  ", Toast.LENGTH_LONG).show();

                        } else if (response.code() == 400) {
                            Toast.makeText(HomeActivity.this,
                                    " add again", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(HomeActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
               // map.put("name", Response.getName)

            }
        });

    }
}