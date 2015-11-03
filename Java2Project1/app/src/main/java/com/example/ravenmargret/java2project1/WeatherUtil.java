package com.example.ravenmargret.java2project1;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by ravenmargret on 11/3/15.
 */
public class WeatherUtil
{
    public static void save(ArrayList<Weather> weathers, Context context)
    {

        try {
            FileOutputStream fileOut = context.openFileOutput("test.txt", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(weathers);
            objectOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Weather> load(Context context)
    {
        try {
            FileInputStream fileIn = context.openFileInput("test.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Weather> savedWeather = (ArrayList<Weather>)objectIn.readObject();
            objectIn.close();
            return savedWeather;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

}
