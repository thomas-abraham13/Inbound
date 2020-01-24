package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.button2);
        login.setOnClickListener((view) -> {
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        });

        Button signup = (Button) findViewById(R.id.button);
        signup.setOnClickListener((view) -> {
            Intent j = new Intent(this, TeamRegistration.class);
            startActivity(j);
        });
    }
}
