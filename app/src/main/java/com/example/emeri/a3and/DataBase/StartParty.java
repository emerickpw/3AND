package com.example.emeri.a3and.DataBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.emeri.a3and.Activity.Interface_Play;
import com.example.emeri.a3and.Activity.Interface_Play_ChronoMod;
import com.example.emeri.a3and.Activity.Interface_Play_ChronoMod2;
import com.example.emeri.a3and.Activity.MainActivity;
import com.example.emeri.a3and.R;

public class StartParty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_party);
        setTitle("Let's Play !");

        //Connect The NormalParty button for redirecting to the activity interface_play activity
        final Button myButtonNormalParty = (Button) findViewById(R.id.buttonNormalParty);
        myButtonNormalParty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartParty.this, Interface_Play.class);
                startActivity(intent);
            }
        });

        //Connect The ChronoParty button for redirecting to the activity interface_play_ChronoMod activity
        final Button myButtonChronoParty = (Button) findViewById(R.id.buttonChronoParty);
        myButtonChronoParty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartParty.this, Interface_Play_ChronoMod.class);
                startActivity(intent);
            }
        });

        //Connect The ChronoParty2 button for redirecting to the activity interface_play activity
        final Button myButtonChronoParty2 = (Button) findViewById(R.id.buttonChronoParty2);
        myButtonChronoParty2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartParty.this, Interface_Play_ChronoMod2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StartParty.this, MainActivity.class);
        startActivity(intent);
    }
}