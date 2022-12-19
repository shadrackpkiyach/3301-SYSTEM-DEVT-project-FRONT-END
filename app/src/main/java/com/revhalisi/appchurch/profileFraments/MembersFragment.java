package com.revhalisi.appchurch.profileFraments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.UserAdapter;
import com.revhalisi.appchurch.api.RetrofitClient;
import com.revhalisi.appchurch.api.models.LoginResult;
import com.revhalisi.appchurch.api.models.MembersModels;
import com.revhalisi.appchurch.api.models.User;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MembersFragment extends Fragment {
    private ListView listView;
    // List<User> userList =new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_members, container, false);
  listView =view.findViewById(R.id.membersList);

        Call<List<MembersModels>> call = RetrofitClient
                .getInstance().getAuthApi().getMembers();

        call.enqueue(new Callback<List<MembersModels>>() {
            @Override
            public void onResponse(Call<List<MembersModels>> call, @NonNull Response<List<MembersModels>> response) {
                if (response.code()==200) {

                    List<MembersModels> users = response.body();

                    UserAdapter adapter = new UserAdapter(getActivity(), users);
                    listView.setAdapter(adapter);

// Pass the names to the custom adapter and display in the ListView
                }
            }

            @Override
            public void onFailure(Call<List<MembersModels>> call, Throwable t) {
// Handle the error
            }
        });
        return view;
    }

}