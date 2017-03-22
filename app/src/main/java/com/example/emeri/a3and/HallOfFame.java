package com.example.emeri.a3and;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HallOfFame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_of_fame);
        setTitle("Hall Of Fame");

        //Connect The Back button for redirecting to the activity Main activity
        final Button myButtonBack = (Button) findViewById(R.id.buttonBack);
        myButtonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallOfFame.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Connect The NormalHoF button for redirecting to the Normal_HoF activity
        final Button myButtonNormalHoF = (Button) findViewById(R.id.buttonNormalHoF);
        myButtonNormalHoF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HallOfFame.this, NormalHoF.class);
                startActivity(intent);
            }
        });


    }
}