package com.example.emeri.a3and.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.emeri.a3and.R;
import com.example.emeri.a3and.Timer.ChronoMod2HoF;
import com.example.emeri.a3and.Timer.ChronoModHoF;

// TODO: 23/03/2017 modifier les parties du layout hardcoded, pour utiliser des strings resources et eviter les warnings au commit 

public class HallOfFame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_of_fame);
        setTitle("Hall Of Fame");


        //Connect The NormalHoF button for redirecting to the Normal_HoF activity
        final Button myButtonNormalHoF = (Button) findViewById(R.id.buttonNormalHoF);
        myButtonNormalHoF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallOfFame.this, NormalHoF.class);
                startActivity(intent);
            }
        });

        //Connect The ChronHoF1 button for redirecting to the Normal_HoF activity
        final Button myButtonChronoModHoF = (Button) findViewById(R.id.buttonHoFChrono1);
        myButtonChronoModHoF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallOfFame.this, ChronoModHoF.class);
                startActivity(intent);
            }
        });

        //Connect The ChronHoF2 button for redirecting to the Normal_HoF activity
        final Button myButtonChronoModHoF2 = (Button) findViewById(R.id.buttonHoFChrono2);
        myButtonChronoModHoF2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallOfFame.this, ChronoMod2HoF.class);
                startActivity(intent);
            }
        });


    }

    //Set the software back button go to the main Activity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HallOfFame.this, MainActivity.class);
        startActivity(intent);
    }

}
