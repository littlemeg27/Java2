/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

package com.example.ravenmargret.java2project4a;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseSyncer extends SQLiteOpenHelper
{
    private static final String DATABASE_FILE = "database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE IF IT DOES NOT EXIST example (" + "_id INTEGER PRIMARY AUTOINCREMENT, some_text TEXT)"; //Dont understand what hit is doing make sure to ask

    public DatabaseSyncer(Context c)
    {
        super(c, DATABASE_FILE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Handle the upgrades
    }
}
