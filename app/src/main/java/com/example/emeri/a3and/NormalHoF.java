package com.example.emeri.a3and;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NormalHoF extends AppCompatActivity {

    //Create object dbhelper class
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_hof);
        setTitle("Top 10 - Normal");

        //initialize db object
        db = new DatabaseHelper(this);
        db.getReadableDatabase();



    }
}