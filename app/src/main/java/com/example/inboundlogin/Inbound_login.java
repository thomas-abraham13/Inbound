package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Inbound_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_login);

        Button next = (Button) findViewById(R.id.button3);
        next.setOnClickListener((view) -> {
            Intent i = new Intent(this, TeamRegistration.class);
            startActivity(i);
        });

        Button cancel = (Button) findViewById(R.id.button4);
        cancel.setOnClickListener((view) -> {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);
        });

    }
}
