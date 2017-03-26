package com.example.emeri.a3and.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.emeri.a3and.DataBase.DatabaseHelper;
import com.example.emeri.a3and.R;

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