package com.example.inboundlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PlayerInfoAdd extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player_info_add, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        EditText name=(EditText)getView().findViewById(R.id.Player_Name);
        EditText number=(EditText)getView().findViewById(R.id.Player_Number);
        EditText IGid=(EditText)getView().findViewById(R.id.Player_id);
        Button done=(Button)getView().findViewById(R.id.btndone);

        done.setOnClickListener(v ->{
            PlayerInfo.Tname[PlayerInfo.count]=name.getText().toString();
            PlayerInfo.Tid[PlayerInfo.count]=IGid.getText().toString();
            PlayerInfo.Tnumber[PlayerInfo.count]=number.getText().toString();
        getActivity().onBackPressed();
        });
    }
    }
