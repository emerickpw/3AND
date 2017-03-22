package com.example.emeri.a3and;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

        //Connect The Back button for redirecting to the activity Main activity
        final Button myButtonBack = (Button) findViewById(R.id.buttonBack);
        myButtonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartParty.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}