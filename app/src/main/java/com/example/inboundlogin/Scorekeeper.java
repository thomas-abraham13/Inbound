package com.example.inboundlogin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Scorekeeper extends AppCompatActivity {

    DatabaseReference databaseScore;

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private static int score1, score2;
    int minutes,seconds;
    String scoreid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorekeeper);

        databaseScore= FirebaseDatabase.getInstance().getReference("score");

        writeScore();

        scoreid = getIntent().getStringExtra("scoreid");

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        EditText team1 = (EditText) findViewById(R.id.team1);
        EditText team2 = (EditText) findViewById(R.id.team2);
        Button Plus1team1 = (Button) findViewById(R.id.Plus1team1);
        Button Plus2team1 = (Button) findViewById(R.id.Plus2team1);
        Button Plus3team1 = (Button) findViewById(R.id.Plus3team1);
        Button Plus1team2 = (Button) findViewById(R.id.Plus1team2);
        Button Plus2team2 = (Button) findViewById(R.id.Plus2team2);
        Button Plus3team2 = (Button) findViewById(R.id.Plus3team2);
        Plus1team1.setOnClickListener(v -> {
            score1 = Integer.valueOf(team1.getText().toString());
            score1++;
            team1.setText(String.valueOf(score1));
            //writeScore();
            updateScore(scoreid);
        });
        Plus2team1.setOnClickListener(v -> {
            score1 = Integer.valueOf(team1.getText().toString());
            score1=score1+2;
            team1.setText(String.valueOf(score1));
            //writeScore();
            updateScore(scoreid);
        });
        Plus3team1.setOnClickListener(v -> {
            score1 = Integer.valueOf(team1.getText().toString());
            score1=score1+3;
            team1.setText(String.valueOf(score1));
            //writeScore();
            updateScore(scoreid);
        });
        Plus1team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2++;
            team2.setText(String.valueOf(score2));
            //writeScore();
            updateScore(scoreid);
        });
        Plus2team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2=score2+2;
            team2.setText(String.valueOf(score2));
            //writeScore();
            updateScore(scoreid);
        });
        Plus3team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2=score2+3;
            team2.setText(String.valueOf(score2));
            //writeScore();
            updateScore(scoreid);
        });
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();

        }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void writeScore(){
        String scoreone=Integer.toString(score1);
        String scoretwo=Integer.toString(score2);
        String mins=Integer.toString(minutes);
        String secs=Integer.toString(seconds);
        String id=databaseScore.push().getKey();

        ScoreDB obj = new ScoreDB(id,scoreone,scoretwo,mins,secs);

        databaseScore.child(id).setValue(obj);
    }

    private void updateScore(final String scoreid){
        String scoreone1=Integer.toString(score1);
        String scoretwo1=Integer.toString(score2);
        String mins1=Integer.toString(minutes);
        String secs1=Integer.toString(seconds);

        ScoreDB obj = new ScoreDB(scoreid,scoreone1,scoretwo1,mins1,secs1);

        databaseScore.setValue(obj);
    }

}
