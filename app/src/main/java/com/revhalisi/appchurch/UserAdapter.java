package com.revhalisi.appchurch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.revhalisi.appchurch.R;
import com.revhalisi.appchurch.api.models.MembersModels;
import com.revhalisi.appchurch.api.models.User;

import java.util.List;

import retrofit2.Callback;

public class UserAdapter extends BaseAdapter {

    private Context mContext;
    private List<MembersModels> mUsers;

    public UserAdapter(Context context, List<MembersModels> users) {
        mContext = context;
        mUsers = users;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.memberss_text_view, parent, false);
        }

        // get current item to be displayed
        User currentUser = (User) getItem(position);

        // get the TextView for item name and item description
        TextView nameTextView = (TextView)
                convertView.findViewById(R.id.text_view_members);


        //sets the text for item name and item description from the current item object
        nameTextView.setText(currentUser.getName());


        // returns the view for the current row
        return convertView;
    }
}
