package com.example.emeri.a3and;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Interface_Play extends AppCompatActivity {

    private int level = 1;

    //Getter/Setters


    public void setLevel(int level) {
        this.level = level;
        Log.d("level", String.valueOf(level));
    }

    public int getLevel() {
        return level;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface_play);

        //Init and display lvl 1 on create

        setTitle("Find Nicolas - Level " + level); //init Level 1

        //create object of RandomValue to define a random picture
        RandomValue value = new RandomValue();
        final String img = value.randomPicture();

        // Get the ImageView
        final ImageView mImageView = (ImageView) findViewById(R.id.imageViewInterface);

        //Set the image
        mImageView.setImageResource(getResources().getIdentifier(img, "mipmap", getPackageName()));

        //Run chronometer
        RunTimerNormal();

        //Connect The Random button for redirecting to the activity interface_play activity
        final Button myButtonRandom = (Button) findViewById(R.id.buttonRandom);
        myButtonRandom.setOnClickListener(new View.OnClickListener() {
            RandomValue randomValue = new RandomValue();

            @Override
            public void onClick(View v) {
                //If level <11, lvl up
                if (getLevel() <11)
                {
                    setTitle("Find Nicolas - Level " + level);
                }
                //Else if lvl > 11, exit the game
                else{
                    Intent intent = new Intent(Interface_Play.this, SaveParty.class);
                    startActivity(intent);
                }

                //Display random picture
                String newImg = randomValue.randomPicture();
                mImageView.setImageResource(getResources().getIdentifier(newImg, "mipmap", getPackageName()));
                //up level
                int newLevel = level + 1;
                setLevel(newLevel);
            }
        });

        //Connect The Win button for redirecting to the activity interface_play activity
        final Button myButtonWin = (Button) findViewById(R.id.buttonVictoire);
        myButtonWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lancer l'activité de Sauvegarde
                Intent intent = new Intent(Interface_Play.this, SaveParty.class);
                startActivity(intent);
            }
        });

    }

    //Disable the software back button, can't escape the game
    public void onBackPressed() {
        //Nothing here, button disabled
    }

    public void RunTimerNormal() {
        Chronometer focus;
        focus = (Chronometer) findViewById(R.id.chronoMetre);
        focus.setBase(SystemClock.elapsedRealtime());

        focus.start();
    }


}
