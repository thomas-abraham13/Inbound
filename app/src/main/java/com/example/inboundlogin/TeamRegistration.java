package com.example.inboundlogin;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeamRegistration extends AppCompatActivity {

    DatabaseReference databaseTeams;

    private EditText team;
    private EditText coach;
    private EditText playerno;
    private Button next;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
        next=(Button) findViewById(R.id.btnnext);
        cancel=(Button) findViewById(R.id.btncancel);
        team=(EditText) findViewById(R.id.TeamName);
        coach=(EditText) findViewById(R.id.CoachName);
        playerno=(EditText) findViewById(R.id.PlayerNo);

        databaseTeams = FirebaseDatabase.getInstance().getReference("teams");
        next.setOnClickListener(v -> {
            if( team.getText().toString().length() == 0 || playerno.getText().toString().length()==0)
            {
                team.setError("Please Enter Team Name");
                playerno.setError("Please Enter Number of Players");
            }
             else {
               //  writeNewTeam();
                Intent i = new Intent(this, PlayerInfo.class);
                i.putExtra("teamname",team.getText().toString());
                //i.putExtra("Player number", playerno.getText());
                startActivity(i);
            }
        });
        cancel.setOnClickListener(v-> {
            Intent i = new Intent(this, HomePage.class);
            startActivity(i);

            Toast.makeText(this, "Team Registration Cancelled", Toast.LENGTH_SHORT).show();
        });

    }

   /* private void writeNewTeam(){
        String teamn = team.getText().toString();
        String coachn = coach.getText().toString();
        String nplay = playerno.getText().toString();
        String id = databaseTeams.push().getKey();

        Teams team = new Teams(id,teamn,coachn,nplay);

        databaseTeams.child(id).setValue(team);
    }
    */
}
