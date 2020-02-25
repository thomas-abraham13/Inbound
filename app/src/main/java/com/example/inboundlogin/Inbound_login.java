package com.example.inboundlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Inbound_login extends AppCompatActivity {

    private EditText username;
    private EditText password;

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        databaseUsers= FirebaseDatabase.getInstance().getReference("user");

        Button login = (Button) findViewById(R.id.button3);
        login.setOnClickListener((view) -> {

            Authenticate(username.getText().toString(),password.getText().toString());

        });

        Button cancel = (Button) findViewById(R.id.button4);
        cancel.setOnClickListener((view) -> {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);

            Toast.makeText(this, "Login Cancelled", Toast.LENGTH_SHORT).show();
        });

        Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener((view) -> {
            Intent j = new Intent(this, PlayerInfo.class);
            startActivity(j);
        });

    }

    private void Authenticate(final String uname, final String upassword)
    {
        databaseUsers.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for(DataSnapshot userSnapshot: dataSnapshot.getChildren())
                {
                    Users user = userSnapshot.getValue(Users.class);

                    if((uname.equals("admin") && upassword.equals("admin")) || (uname.equals(user.getEmailid())&& upassword.equals(user.getPass())))
                    {
                        Intent i = new Intent(Inbound_login.this, HomePage.class);
                        i.putExtra("useid",user.getId());
                        startActivity(i);

                        Toast.makeText(Inbound_login.this, "User Successfully Logged In", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(Inbound_login.this, "Username or Password is Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
