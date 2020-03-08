package com.example.inboundlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Scoreboard extends AppCompatActivity {

    DatabaseReference databaseScore;

    String scoreid;

    private TextView score1;
    private TextView score2;
    private TextView minutes;
    private TextView seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        databaseScore= FirebaseDatabase.getInstance().getReference("score");

        scoreid = getIntent().getStringExtra("scoreid");

        score1=findViewById(R.id.team2score);
        score2=findViewById(R.id.team1score);
        minutes=findViewById(R.id.mins);
        seconds=findViewById(R.id.secs);

        getData(scoreid);
    }

    private void getData(final String id){
        databaseScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ScoreDB obj = dataSnapshot.getValue(ScoreDB.class);

                score1.setText(obj.getScore1());
                score2.setText(obj.getScore2());
                minutes.setText(obj.getMinutes());
                seconds.setText(obj.getSeconds());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
