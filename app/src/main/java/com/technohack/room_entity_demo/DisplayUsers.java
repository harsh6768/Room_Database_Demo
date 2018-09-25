package com.technohack.room_entity_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DisplayUsers extends AppCompatActivity {

    List<DisplayUserPojo> displayUsersList;

    private RecyclerView myRecyclerView;
    private DisplayRecyclerViewAdapter displayRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);

        myRecyclerView=findViewById(R.id.details_user_recyclerId);
        displayUsersList=new ArrayList<>();

        List<Users> users=MainActivity.myRoomDatabase.myDao().getUsers();

        for(int i=0;i<users.size();i++){

            int userId=users.get(i).getUid();
            String userName=users.get(i).getName();
            String userEmail=users.get(i).getEmail();

            Log.i("Log for checking value:",userId+userName+userEmail);

            displayUsersList.add(new DisplayUserPojo(userId,userName,userEmail));

        }

        displayRecyclerViewAdapter=new DisplayRecyclerViewAdapter(getApplicationContext(),displayUsersList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(displayRecyclerViewAdapter);
        displayRecyclerViewAdapter.notifyDataSetChanged();


    }

}
