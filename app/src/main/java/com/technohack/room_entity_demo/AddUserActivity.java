package com.technohack.room_entity_demo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    private EditText addUserId,addUserName,addUserEmail;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        addUserId=findViewById(R.id.add_UserId);
        addUserName=findViewById(R.id.add_user_nameId);
        addUserEmail=findViewById(R.id.add_user_emailId);
        save=findViewById(R.id.add_btnId);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int userId=Integer.parseInt(addUserId.getText().toString().trim());
                String userName=addUserName.getText().toString().trim();
                String userEmail=addUserEmail.getText().toString().trim();

                Users users=new Users(userId,userName,userEmail);

                //to add the user into the Room Database
                MainActivity.myRoomDatabase.myDao().addUser(users);

                Toast.makeText(AddUserActivity.this,"User Added Successfully!!!",Toast.LENGTH_LONG).show();

                addUserId.setText("");
                addUserName.setText("");
                addUserEmail.setText("");


            }
        });
    }

}
