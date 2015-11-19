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

import java.util.ArrayList;

public class PersonListFragment extends ListFragment
{
    private OnFragmentInteractionListener mListener;
    ArrayList<Form> formObject;

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

        Cursor cursor = getContentResolver().query(CRUDProvider.CONTENT_URI, DatabaseSyncer.ALL, null, null, null);

        String[] from = {DatabaseSyncer.FIRST_NAME};
        int[] to = {android.R.id.text1};
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor,from, to, 0);

        if(formObject == null)
        {
            Toast.makeText(getActivity(), "The list is empty", Toast.LENGTH_LONG).show();
        }
        else
        {
            loadData();
            addCrud();
        }
    }

    private void addCrud()
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseSyncer.FIRST_NAME, "First Name");
        values.put(DatabaseSyncer.LAST_NAME, "Last Name");
        values.put(DatabaseSyncer.AGE, "Age");
        Uri crudUri = getContentResolver().insert(CRUDProvider.CONTENT_URI, values);
        Log.e("Main", "TESTING" + crudUri.getLastPathSegment());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Form f = (Form) getListAdapter().getItem(position);
        mListener.onFragmentInteraction(f);
    }

    public void loadData()
    {
        formObject = FormUtil.load(getActivity());
        ArrayAdapter<Form> formArrayAdapter = new ArrayAdapter<Form>(getActivity(), android.R.layout.simple_list_item_1, formObject);
        setListAdapter(formArrayAdapter);
    }

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Form formObject);
    }
}
