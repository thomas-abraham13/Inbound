package com.example.inboundlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlayerInfo extends AppCompatActivity {

    //DatabaseReference databasePlayers;

    //String pteam = getIntent().getStringExtra("teamname");

    private static final String TAG = "MainActivity";

    public static String[] Tname = new String[12];
    public static String[] Tnumber = new String[12];
    public static String[] Tid = new String[12];
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        //databasePlayers = FirebaseDatabase.getInstance().getReference("players");

        Button addPlayer = (Button) findViewById(R.id.btnadd);
        final FrameLayout f = (FrameLayout) findViewById(R.id.frameLayout);
        EditText name1 = (EditText) findViewById(R.id.Name1);
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText id1 = (EditText) findViewById(R.id.id1);
        EditText name2 = (EditText) findViewById(R.id.Name2);
        EditText number2 = (EditText) findViewById(R.id.number2);
        EditText id2 = (EditText) findViewById(R.id.id2);
        EditText name3 = (EditText) findViewById(R.id.Name3);
        EditText number3 = (EditText) findViewById(R.id.number3);
        EditText id3 = (EditText) findViewById(R.id.id3);
        EditText name4 = (EditText) findViewById(R.id.Name4);
        EditText number4 = (EditText) findViewById(R.id.number4);
        EditText id4 = (EditText) findViewById(R.id.id4);
        EditText name5 = (EditText) findViewById(R.id.Name5);
        EditText number5 = (EditText) findViewById(R.id.number5);
        EditText id5 = (EditText) findViewById(R.id.id5);
        EditText name6 = (EditText) findViewById(R.id.Name6);
        EditText number6 = (EditText) findViewById(R.id.number6);
        EditText id6 = (EditText) findViewById(R.id.id6);
        EditText name7 = (EditText) findViewById(R.id.Name7);
        EditText number7 = (EditText) findViewById(R.id.number7);
        EditText id7 = (EditText) findViewById(R.id.id7);
        EditText name8 = (EditText) findViewById(R.id.Name8);
        EditText number8 = (EditText) findViewById(R.id.number8);
        EditText id8 = (EditText) findViewById(R.id.id8);
        EditText name9 = (EditText) findViewById(R.id.Name9);
        EditText number9 = (EditText) findViewById(R.id.number9);
        EditText id9 = (EditText) findViewById(R.id.id9);
        EditText name10 = (EditText) findViewById(R.id.Name10);
        EditText number10 = (EditText) findViewById(R.id.number10);
        EditText id10 = (EditText) findViewById(R.id.id10);
        EditText name11 = (EditText) findViewById(R.id.Name11);
        EditText number11 = (EditText) findViewById(R.id.number11);
        EditText id11 = (EditText) findViewById(R.id.id11);
        EditText name12 = (EditText) findViewById(R.id.Name12);
        EditText number12 = (EditText) findViewById(R.id.number12);
        EditText id12 = (EditText) findViewById(R.id.id12);
        addPlayer.setOnClickListener((view) -> {
            if (count == 1) {
                name1.setText(Tname[count]);
                number1.setText(Tnumber[count]);
                id1.setText(Tid[count]);
                name1.setVisibility(View.VISIBLE);
                number1.setVisibility(View.VISIBLE);
                id1.setVisibility(View.VISIBLE);
            } else if (count == 2) {
                name2.setText(Tname[count]);
                number2.setText(Tnumber[count]);
                id2.setText(Tid[count]);
                name2.setVisibility(View.VISIBLE);
                number2.setVisibility(View.VISIBLE);
                id2.setVisibility(View.VISIBLE);
            } else if (count == 3) {
                name3.setText(Tname[count]);
                number3.setText(Tnumber[count]);
                id3.setText(Tid[count]);
                name3.setVisibility(View.VISIBLE);
                number3.setVisibility(View.VISIBLE);
                id3.setVisibility(View.VISIBLE);
            } else if (count == 4) {
                name4.setText(Tname[count]);
                number4.setText(Tnumber[count]);
                id4.setText(Tid[count]);
                name4.setVisibility(View.VISIBLE);
                number4.setVisibility(View.VISIBLE);
                id4.setVisibility(View.VISIBLE);
            } else if (count == 5) {
                name5.setText(Tname[count]);
                number5.setText(Tnumber[count]);
                id5.setText(Tid[count]);
                name5.setVisibility(View.VISIBLE);
                number5.setVisibility(View.VISIBLE);
                id5.setVisibility(View.VISIBLE);
            } else if (count == 6) {
                name6.setText(Tname[count]);
                number6.setText(Tnumber[count]);
                id6.setText(Tid[count]);
                name6.setVisibility(View.VISIBLE);
                number6.setVisibility(View.VISIBLE);
                id6.setVisibility(View.VISIBLE);
            } else if (count == 7) {
                name7.setText(Tname[count]);
                number7.setText(Tnumber[count]);
                id7.setText(Tid[count]);
                name7.setVisibility(View.VISIBLE);
                number7.setVisibility(View.VISIBLE);
                id7.setVisibility(View.VISIBLE);
            } else if (count == 8) {
                name8.setText(Tname[count]);
                number8.setText(Tnumber[count]);
                id8.setText(Tid[count]);
                name8.setVisibility(View.VISIBLE);
                number8.setVisibility(View.VISIBLE);
                id8.setVisibility(View.VISIBLE);
            } else if (count == 9) {
                name9.setText(Tname[count]);
                number9.setText(Tnumber[count]);
                id9.setText(Tid[count]);
                name9.setVisibility(View.VISIBLE);
                number9.setVisibility(View.VISIBLE);
                id9.setVisibility(View.VISIBLE);
            } else if (count == 10) {
                name10.setText(Tname[count]);
                number10.setText(Tnumber[count]);
                id10.setText(Tid[count]);
                name10.setVisibility(View.VISIBLE);
                number10.setVisibility(View.VISIBLE);
                id10.setVisibility(View.VISIBLE);
            } else if (count == 11) {
                name11.setText(Tname[count]);
                number11.setText(Tnumber[count]);
                id11.setText(Tid[count]);
                name11.setVisibility(View.VISIBLE);
                number11.setVisibility(View.VISIBLE);
                id11.setVisibility(View.VISIBLE);
            } else if (count == 12) {
                name12.setText(Tname[count]);
                number12.setText(Tnumber[count]);
                id12.setText(Tid[count]);
                name12.setVisibility(View.VISIBLE);
                number12.setVisibility(View.VISIBLE);
                id12.setVisibility(View.VISIBLE);
            }
            count++;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frameLayout, new PlayerInfoAdd());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        Button finish = (Button) findViewById(R.id.btnfinish);
        finish.setOnClickListener((view) -> {
            Intent j = new Intent(this, HomePage.class);
            startActivity(j);

                /*for(int i=0; i<count; i++)
                {
                    writeNewPlayer(i);
                }

                Toast.makeText(this, "Team Registration Complete", Toast.LENGTH_SHORT).show();

                Tname=null;
                Tnumber=null;
                Tid=null;
            });
        */
        });

        /*private void writeNewPlayer(int j){
            String pname=Tname[j];
            String teamp=pteam;
            String pnumber=Tnumber[j];
            String pinstagram=Tid[j];
            String id=databasePlayers.push().getKey();

            Players obj = new Players(pname,teamp,pnumber,pinstagram,id);

            databasePlayers.child(id).setValue(obj);

        }
*/
    }
}
