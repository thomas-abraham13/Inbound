package com.example.inboundlogin;

import android.content.Intent;
import android.media.MediaExtractor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TeamRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
        Button next=(Button) findViewById(R.id.btnnext);
        Button cancel=(Button) findViewById(R.id.btncancel);
        EditText team=(EditText) findViewById(R.id.TeamName);
        EditText coach=(EditText) findViewById(R.id.CoachName);
        EditText playerno=(EditText) findViewById(R.id.PlayerNo);
        Button scorekeeper=(Button) findViewById(R.id.btnscore);
        next.setOnClickListener(v -> {
            if( team.getText().toString().length() == 0 || playerno.getText().toString().length()==0) {
                team.setError("Team name is required!");
                playerno.setError("Number of players is required!");
            }
             else {
                Intent i = new Intent(this, PlayerInfo.class);
                i.putExtra("Player number", playerno.getText());
                startActivity(i);
            }
        });
        cancel.setOnClickListener(v-> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
        scorekeeper.setOnClickListener(v-> {
            Intent j = new Intent(this, Scorekeeper.class);
            startActivity(j);
        });
    }

}
