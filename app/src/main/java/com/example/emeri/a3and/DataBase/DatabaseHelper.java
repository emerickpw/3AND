package com.example.emeri.a3and.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by emeri on 25/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "sqliteDataBase";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlScore = "CREATE TABLE scores(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, level INTEGER,time LONG, gamemode VARCHAR);";

        sqLiteDatabase.execSQL(sqlScore);
    }

    public boolean addScore(String name, int level, long time, String gamemode) {
        Log.d("test", "1");
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("level", level);
        contentValues.put("time", time);
        contentValues.put("gamemode", gamemode);
        Log.d("test", "2");
        sqLiteDatabase.insert("scores", null, contentValues);
        sqLiteDatabase.close();
        return true;
    }

    public Cursor getScore(SQLiteDatabase db) {

        //String Scores = {}

        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sqlScore = "DROP TABLE IF EXISTS scores";

        sqLiteDatabase.execSQL(sqlScore);

    }

}
