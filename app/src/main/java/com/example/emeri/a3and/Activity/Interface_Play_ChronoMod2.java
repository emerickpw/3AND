package com.example.emeri.a3and.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emeri.a3and.R;
import com.example.emeri.a3and.TouchScreen.RandomValue;
import com.example.emeri.a3and.DataBase.SaveParty;
import com.example.emeri.a3and.TouchScreen.TouchImageView;

import java.util.concurrent.TimeUnit;

public class Interface_Play_ChronoMod2 extends AppCompatActivity {

    private int level = 1;
    TextView countDown;

    private static final String FORMAT = "%02d:%02d";

    int seconds , minutes;


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
        setContentView(R.layout.interface_play_chronomod);

        //Define the Countdown TextView
        countDown=(TextView)findViewById(R.id.textViewCountDown);

        //Init and display lvl 1 on create

        setTitle("Find Nicolas - Level " + level); //init Level 1


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
        RunTimerChronoMod();


        //Connect The Random button for redirecting to the activity interface_play activity
        final Button myButtonRandom = (Button) findViewById(R.id.buttonRandom);
        myButtonRandom.setOnClickListener(new View.OnClickListener() {
            RandomValue randomValue = new RandomValue();

            @Override
            public void onClick(View v) {
                //lancer la methode random Picture
                String newImg = randomValue.randomPicture();
                imageControlled.setImageResource(getResources().getIdentifier(newImg, "mipmap", getPackageName()));
                //up level
                int newLevel = level + 1;
                setLevel(newLevel);
                setTitle("Find Nicolas - Level " + level);

            }
        });


    }

    //Disable the software back button, can't escape the game
    public void onBackPressed() {
        //Nothing here, button disabled
    }


    //Countdown Method
    public void RunTimerChronoMod() {
        //Set time duration in millisenconds
        new CountDownTimer(10*1000,1000){       //Duration 120seconds, refresh every seconds
            @Override

            public void onTick(long millisUntilFinished) {
                countDown.setText(""+String.format(FORMAT,
                        //TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }


            @Override

            //Define what happen when time's up
            // Passage des parametres sur l'activité de sauvegarde, puis lancement de l'activité de sauvegarde
            public void onFinish() {
                Intent intent = new Intent(Interface_Play_ChronoMod2.this, SaveParty.class);
                intent.putExtra("Level",getLevel());
                intent.putExtra("GameMode", "ChronoMod2");
                startActivity(intent);
            }
        }.start();
    }
}
