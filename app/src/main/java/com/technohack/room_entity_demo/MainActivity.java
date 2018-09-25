package com.technohack.room_entity_demo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static MyRoomDatabase myRoomDatabase;

    private Button addUserbtn;
    private Button displayUserBtn;
    private Button deleteUserBtn;
    private Button updateUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to create the database as userdb
        // allowMainThreadQueries is allow the backend thread to run into the UI THREAD
        myRoomDatabase= Room.databaseBuilder(getApplicationContext(),MyRoomDatabase.class,"userdb").allowMainThreadQueries().build();

        addUserbtn=findViewById(R.id.add_userBtnId);
        displayUserBtn=findViewById(R.id.display_BtnId);
        deleteUserBtn=findViewById(R.id.delete_userBtnId);
        updateUserBtn=findViewById(R.id.update_userBtnId);

        addUserbtn.setOnClickListener(this);
        displayUserBtn.setOnClickListener(this);
        deleteUserBtn.setOnClickListener(this);
        updateUserBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){

             case R.id.add_userBtnId:
                 startActivity(new Intent(MainActivity.this,AddUserActivity.class));
                 break;
             case R.id.display_BtnId:
                 startActivity(new Intent(MainActivity.this,DisplayUsers.class));
                 break;
             case R.id.delete_userBtnId:
                 startActivity(new Intent(MainActivity.this,DeleteUserActivity.class));
                 break;
             case R.id.update_userBtnId:
                 startActivity(new Intent(MainActivity.this,UpdateUserActivity.class));
                 break;


         }
    }
}
