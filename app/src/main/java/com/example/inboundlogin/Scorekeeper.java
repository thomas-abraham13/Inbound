package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.lang.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.util.Locale;;

public class Scorekeeper extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private static int score1, score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorekeeper);

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
        });
        Plus2team1.setOnClickListener(v -> {
            score1 = Integer.valueOf(team1.getText().toString());
            score1=score1+2;
            team1.setText(String.valueOf(score1));
        });
        Plus3team1.setOnClickListener(v -> {
            score1 = Integer.valueOf(team1.getText().toString());
            score1=score1+3;
            team1.setText(String.valueOf(score1));
        });
        Plus1team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2++;
            team2.setText(String.valueOf(score2));
        });
        Plus2team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2=score2+2;
            team2.setText(String.valueOf(score2));
        });
        Plus3team2.setOnClickListener(v -> {
            score2 = Integer.valueOf(team2.getText().toString());
            score2=score2+3;
            team2.setText(String.valueOf(score2));
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
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}
