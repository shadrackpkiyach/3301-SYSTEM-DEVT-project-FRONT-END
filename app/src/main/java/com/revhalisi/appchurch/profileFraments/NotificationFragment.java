package com.revhalisi.appchurch.profileFraments;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.revhalisi.appchurch.R;

public class NotificationFragment extends Fragment {
    SwitchCompat switchButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        ((SwitchCompat) view.findViewById(R.id.switchPhoneButton))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Activity activity = getActivity();

                        if (activity != null) {
                            Toast.makeText(activity,
                                    R.string.toast_you_just_clicked_a_fragment,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });
        ((SwitchCompat) view.findViewById(R.id.switchEmailButton))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Activity activity = getActivity();

                        if (activity != null) {
                            Toast.makeText(activity,
                                    R.string.toast_you_just_clicked_a_fragment,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });

        return view;

    }
}