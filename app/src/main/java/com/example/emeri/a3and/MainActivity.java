package com.example.emeri.a3and;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        //Connect The play button for redirecting to the start_party activity
    final Button myButtonPlay = (Button) findViewById(R.id.buttonPlay);
    myButtonPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartParty.class);
                startActivity(intent);
            }
        });
        //Connect The Hall Of Fame button for redirecting to the hall_of_fame activity
    final Button myButtonHoF = (Button) findViewById(R.id.buttonHallOfFame);
    myButtonHoF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HallOfFame.class);
                startActivity(intent);
            }
        });

    }

    //Disable the software back button, can't escape the game
    public void onBackPressed() {
        //Nothing here, button disabled
    }
}