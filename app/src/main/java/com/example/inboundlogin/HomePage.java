package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button teamregis = (Button) findViewById(R.id.teamregis);
        teamregis.setOnClickListener((view) -> {
            Intent i = new Intent(this, TeamRegistration.class);
            startActivity(i);
        });

        Button scorekeep = (Button) findViewById(R.id.scorekeeper);
        scorekeep.setOnClickListener((view) -> {
            Intent i = new Intent(this, Scorekeeper.class);
            startActivity(i);
        });

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener((view) -> {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);

            Toast.makeText(this, "User Successfully Logged Out", Toast.LENGTH_SHORT).show();
        });
    }
}