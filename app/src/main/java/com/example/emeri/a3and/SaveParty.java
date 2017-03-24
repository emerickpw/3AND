package com.example.emeri.a3and;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SaveParty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_party);
        setTitle("Let's save!");

        //Connect The Save button for Saving, and then redirecting to the activity Hall Of Fame activity
        final Button myButtonSave = (Button) findViewById(R.id.buttonSave);
        myButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save game record
                // TODO: 23/03/2017 mettre en place la connexion a la BDD + sauvegarde de la partie
                //Launch Save Activity
                Intent intent = new Intent(SaveParty.this, HallOfFame.class);
                startActivity(intent);
            }
        });

    }

    //Disable the software back button, can't escape the game
    public void onBackPressed() {
        //Nothing here, button disabled
    }}