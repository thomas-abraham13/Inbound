package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Inbound_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_signup);

        Button next = (Button) findViewById(R.id.button5);
        next.setOnClickListener((view) -> {
            Intent i = new Intent(this, Inbound_login.class);
            startActivity(i);
        });

        Button cancel = (Button) findViewById(R.id.button6);
        cancel.setOnClickListener((view) -> {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);
        });
    }
}
