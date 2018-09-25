package com.technohack.room_entity_demo;

import android.arch.persistence.room.Update;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUserActivity extends AppCompatActivity {

    private EditText userId,userName,userEmail;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);


        userId=findViewById(R.id.update_userId);
        userName=findViewById(R.id.update_user_nameId);
        userEmail=findViewById(R.id.update_user_emailId);
        updateBtn=findViewById(R.id.update_btnId);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id=Integer.parseInt(userId.getText().toString().trim());
                String name=userName.getText().toString().trim();
                String email=userEmail.getText().toString().trim();

                Users users=new Users(id,name,email);

                MainActivity.myRoomDatabase.myDao().updateUser(users);

                Toast.makeText(UpdateUserActivity.this,"Data Updated Successfully!!!",Toast.LENGTH_LONG).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        });
    }
}
