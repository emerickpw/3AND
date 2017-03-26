package com.example.emeri.a3and.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.emeri.a3and.DataBase.SaveParty;
import com.example.emeri.a3and.R;
import com.example.emeri.a3and.TouchScreen.RandomValue;
import com.example.emeri.a3and.TouchScreen.TouchImageView;

public class Interface_Play extends AppCompatActivity {

    private int level = 1;
    private Handler mHandler = new Handler();
    long TempBase;

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

        //Create ImageView to be controlled
        final TouchImageView imageControlled = new TouchImageView(this);
        imageControlled.setImageResource(getResources().getIdentifier("cage1", "mipmap", getPackageName()));
        imageControlled.setMaxZoom(6f);

        //Create the LynearLayout where the ImageView will be displayed
        LinearLayout lL = (LinearLayout) findViewById(R.id.normal_game_layout);
        imageControlled.setVisibility(View.VISIBLE);


        //Layout parameter to fetch in the ContentView
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.TOP;
        lp.height = 1320;
        imageControlled.setLayoutParams(lp);

        //Add interactive listener
        imageControlled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cage FOUNDED !! " , Toast.LENGTH_SHORT).show();
            }
        });

        imageControlled.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Not here !! " , Toast.LENGTH_SHORT).show();

                return true;
            }

        });
        //Display image
        lL.addView(imageControlled,0);



        //Run chronometer
        RunTimerNormal();

        //Connect The Random button for redirecting to the activity interface_play activity
        final Button myButtonRandom = (Button) findViewById(R.id.buttonRandom);
        myButtonRandom.setOnClickListener(new View.OnClickListener() {
            RandomValue randomValue = new RandomValue();

            @Override
            public void onClick(View v) {
                //If level <11, lvl up
                if (getLevel() <10)
                {
                    setTitle("Find Nicolas - Level " + level);
                }
                //Else if lvl == 10, exit the game
                else{
                    //Definition du temps
                    long tempsReel = SystemClock.elapsedRealtime() - TempBase;
                    //lancer l'activité de Sauvegarde et passage des parametres
                    Intent intent = new Intent(Interface_Play.this, SaveParty.class);
                    intent.putExtra("Level",getLevel());
                    intent.putExtra("GameMode", "Normal");
                    intent.putExtra("Chronometer", tempsReel);

                    startActivity(intent);
                }


                //Display random picture
                String newImg = randomValue.randomPicture();
                imageControlled.setImageResource(getResources().getIdentifier(newImg, "mipmap", getPackageName()));


                //up level
                int newLevel = level + 1;
                setLevel(newLevel);

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
        TempBase = focus.getBase();
        focus.start();
    }


}
