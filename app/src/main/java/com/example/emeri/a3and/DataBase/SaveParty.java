package com.example.emeri.a3and.DataBase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.example.emeri.a3and.Activity.HallOfFame;
import com.example.emeri.a3and.R;

public class SaveParty extends AppCompatActivity {

    //Create object dbhelper class
    DatabaseHelper db;

    EditText textName;
    Chronometer textTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_party);
        setTitle("Let's save!");

        //Connect editbox
        textName = (EditText) findViewById(R.id.editTextName);
        //Get the data from the party
        Intent intent = getIntent();
        final String GameMode = intent.getStringExtra("GameMode");
        final int level = intent.getIntExtra("Level", 0); //24
        final Long chronometer = intent.getLongExtra("Chronometer", 0);

        //Connect The Level TextView for Displaying Level
        final TextView myTextViewLevel = (TextView) findViewById(R.id.textViewLevel);
        //Display Level here
        myTextViewLevel.setText("Level " + level);

        //Connect The Gamemode TextView for Displaying Level
        final TextView myTextViewGameMode = (TextView) findViewById(R.id.textViewGameMode);
        //Display Level here
        myTextViewGameMode.setText("Game Mode : " + GameMode);

        //Connect The Timer TextView for Displaying Level
        final TextView myTextViewTimer = (TextView) findViewById(R.id.textViewTimer);
        //Display Level here only for normal game
        myTextViewTimer.setText("Your Time: " + (chronometer/1000) + "seconds");


        //initialize db object
        db = new DatabaseHelper(this);


        //Connect The Save button for Saving, and then redirecting to the activity Hall Of Fame activity
        final Button myButtonSave = (Button) findViewById(R.id.buttonSave);
        myButtonSave.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                //Save game record
                Log.d("test","enregistrement");
                final String name = textName.getText().toString();
                db.addScore(name, level,(chronometer/1000), GameMode);  //Set chronometer from ms to sec


                //Launch HoF Activity
                Log.d("change","Activity");
                Intent intent = new Intent(SaveParty.this, HallOfFame.class);
                startActivity(intent);
            }
        });

    }

    //Disable the software back button, can't escape the game
    public void onBackPressed() {
        //Nothing here, button disabled
    }
}