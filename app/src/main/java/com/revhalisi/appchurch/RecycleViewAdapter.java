package com.revhalisi.appchurch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revhalisi.appchurch.api.models.PostModels;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter <RecycleViewAdapter.MyViewHolder>{
     Context context;
    List<PostModels> postModelsList;

    public RecycleViewAdapter(List<PostModels> postModelsList, Context context) {
        this.postModelsList = postModelsList;
        this.context = context;
    }

public class MyViewHolder extends  RecyclerView.ViewHolder{
   TextView titleA;
   TextView informationA;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        titleA = itemView.findViewById(R.id.TitleId);
        informationA= itemView.findViewById(R.id.postId);
    }
}
    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.church_post,parent,false);
      MyViewHolder holder = new MyViewHolder(view);


        return  holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {
   holder.titleA.setText(postModelsList.get(position).getTitle());
   holder.informationA.setText(postModelsList.get(position).getInformation());
   //glide for image
    }

    @Override
    public int getItemCount() {
        return postModelsList.size();
    }
}
