/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.java2project3;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FormUtil
{
    public static void save(ArrayList<Form> forms, Context context)
    {
        try
        {
            FileOutputStream fileOut = context.openFileOutput("test.txt", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(forms);
            objectOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<Form> load(Context context)
    {
        try
        {
            FileInputStream fileIn = context.openFileInput("test.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Form> savedForm = (ArrayList<Form>)objectIn.readObject();
            objectIn.close();
            return savedForm;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void save(Form form, Context context) //Saving one item at a time
    {
        ArrayList<Form> loadedItem = load(context);
        if (loadedItem == null)
        {
            loadedItem = new ArrayList<>();
        }
        loadedItem.add(form);
        save(loadedItem, context);
    }

    public static void delete(Form form, Context context) //Delete one item at a time
    {
        ArrayList<Form> loadedItem = load(context);

        loadedItem.remove(form);
    }
}
