/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

package com.example.ravenmargret.java2project4a;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.ArrayList;

public class PersonListFragment extends ListFragment
{
    private OnFragmentInteractionListener mListener;
    ArrayList<String> dataForm = new ArrayList<String>();

    public PersonListFragment()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        String[] columns = {Contract.ID, Contract.FIRST_NAME, Contract.LAST_NAME, Contract.AGE};

        Cursor cursor = getActivity().getContentResolver().query(Uri.parse(Contract.DATA_SOURCE_URI), columns, null, null, null);

        String[] fromDatabase = {Contract.FIRST_NAME};
        int[] setToList = {android.R.id.text1};
        CursorAdapter adapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_1, cursor, fromDatabase, setToList, 0);
        setListAdapter(adapter);

        int columnIndex = cursor.getColumnIndex(Contract.FIRST_NAME);
        int columnIndex1 = cursor.getColumnIndex(Contract.LAST_NAME);
        int columnIndex2 = cursor.getColumnIndex(Contract.AGE);

        while (cursor.moveToNext())
        {
            dataForm.add(cursor.getString(columnIndex));
            dataForm.add(cursor.getString(columnIndex1));
            dataForm.add(cursor.getString(columnIndex2));
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        String selectedItem = dataForm.get(position).toString();
        //dataForm d = (dataForm)getListAdapter().getItem(position);
        mListener.onFragmentInteraction();
    }


    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
