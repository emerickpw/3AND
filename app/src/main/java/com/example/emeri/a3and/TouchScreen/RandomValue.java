package com.example.emeri.a3and.TouchScreen;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Random;


public class RandomValue extends AppCompatActivity {
    //Declare Var
    private int previousValue;
    private int valueRand;

    public int getPreviousValue() {
        return previousValue;
    }

    public int getValueRand() {
        return valueRand;
    }

    public void setPreviousValue(int previousValue) {
        this.previousValue = previousValue;
    }

    public void setValueRand(int valueRand) {
        this.valueRand = valueRand;
    }

    public String randomPicture(){
        Random rnd = new Random();
        //try to catch another picture
        do {
            valueRand = (rnd.nextInt(5) + 0);
        }
        while (valueRand == previousValue);

        //Log.d("Previous Value", String.valueOf(previousValue));
        //Log.d("Current Value", String.valueOf(valueRand));
        setPreviousValue(valueRand);
        //Log.d("val modif prvs Val",String.valueOf(previousValue));


        String img = "cage" + valueRand;       //Rename to catch img name
        Log.d("Valeur IMG", img);
        return img;
    }

}
