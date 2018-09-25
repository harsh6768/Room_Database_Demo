package com.technohack.room_entity_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteUserActivity extends AppCompatActivity {

    private TextView userId;
    private Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        userId=findViewById(R.id.delete_userId);
        deleteBtn=findViewById(R.id.delete_userBtnId);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id=Integer.parseInt(userId.getText().toString().trim());

                Users users=new Users();
                users.setUid(id);

                MainActivity.myRoomDatabase.myDao().deleteUser(users);

                Toast.makeText(DeleteUserActivity.this,"User's Data deleted Successfully!",Toast.LENGTH_LONG).show();

                userId.setText("");

            }
        });
    }
}
