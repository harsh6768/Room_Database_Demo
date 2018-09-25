package com.technohack.room_entity_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DisplayRecyclerViewAdapter extends RecyclerView.Adapter<DisplayRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<DisplayUserPojo> displayUsersList;

    public DisplayRecyclerViewAdapter(Context context, List<DisplayUserPojo> displayUsersList) {
        this.context = context;
        this.displayUsersList = displayUsersList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.display_user_list,parent,false);
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {


        //when i am trying to display the id it throw the error ... i have tried to remove that error but i couldn't

       // myViewHolder.userId.setText(displayUsersList.get(position).getUserId());

        myViewHolder.userName.setText(displayUsersList.get(position).getUserName());
        myViewHolder.userEmail.setText(displayUsersList.get(position).getUserEmail());

    }

    @Override
    public int getItemCount() {

        return displayUsersList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userId;
        TextView userName;
        TextView userEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userId=itemView.findViewById(R.id.display_userId);
            userName=itemView.findViewById(R.id.display_userNameId);
            userEmail=itemView.findViewById(R.id.display_userEmailId);

        }
    }

}
