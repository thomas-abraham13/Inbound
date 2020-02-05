package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Inbound_signup extends AppCompatActivity {

    private EditText username;
    private EditText password;

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        databaseUsers= FirebaseDatabase.getInstance().getReference("user");

        Button next = (Button) findViewById(R.id.button5);
        next.setOnClickListener((view) -> {
            writeNewUser();
            Intent i = new Intent(this, Inbound_login.class);
            startActivity(i);
        });

        Button cancel = (Button) findViewById(R.id.button6);
        cancel.setOnClickListener((view) -> {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);
        });
    }

    private void writeNewUser() {
        String email = username.getText().toString();
        String pass = password.getText().toString();
        String id = databaseUsers.push().getKey();

        Users user = new Users(email,pass,id);

        databaseUsers.child(id).setValue(user);
    }

}
