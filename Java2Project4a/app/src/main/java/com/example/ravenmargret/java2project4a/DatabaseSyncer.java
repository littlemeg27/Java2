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

    public static final String CRUD_TABLE = "Crud";
    public static final String ID = "_id"; //Constants for table and columns
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String AGE = "age";

    private static final String CREATE_TABLE = "CREATE TABLE " + CRUD_TABLE + "(" +
                                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                FIRST_NAME + "FIRST NAME" +
                                LAST_NAME + "LAST NAME " +
                                AGE + " AGE " + ")";

    public static final String[] ALL = {ID, FIRST_NAME, LAST_NAME, AGE};


    public DatabaseSyncer(Context context)
    {
        super(context, DATABASE_FILE, null, DATABASE_VERSION);
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
        db.execSQL("DROP TABLE IF EXISTS " + CRUD_TABLE);
        onCreate(db);
    }
}
