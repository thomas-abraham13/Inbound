package com.example.inboundlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String id = getIntent().getStringExtra("useid");

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

        ImageButton setting = (ImageButton) findViewById(R.id.settings);
        setting.setOnClickListener((view) -> {
            Intent i = new Intent(this, Settings.class);
            i.putExtra("useid",id);
            startActivity(i);
        });

        Button bballdrill = (Button) findViewById(R.id.bdrills);
        bballdrill.setOnClickListener((view) -> {
            Intent j = new Intent(this, Bballdrills.class);
            startActivity(j);
        });

        Button playstats = (Button) findViewById(R.id.playstats);
        playstats.setOnClickListener((view) -> {
            Intent j = new Intent(this, Scoreboard.class);
            startActivity(j);
        });


    }
}
