/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import android.widget.Spinner;

import com.example.ravenmargret.java2project1.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */

public class MasterFragment extends ListFragment implements WeatherTask.WeatherDataReceiver
{
    ArrayList<Weather> mObjects;
    private OnFragmentInteractionListener mListener;
    Spinner citySpinner;
    ArrayAdapter<String> spinnerAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    @Override
    public void receiveData(ArrayList<Weather> weatherForecast)
    {
        //Get in weather data
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, weatherForecast));
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

        /*citySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(MasterFragment.this, R.array.spinnerArray, android.R.layout.simple_dropdown_item_1line);
        citySpinner.setAdapter(spinnerAdapter);*/

        try
        {
            ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE); //Check network class
            WeatherTask myTask = new WeatherTask(getActivity(), this);
            myTask.execute("http://api.wunderground.com/api/7cba3eee76e99b48/forecast10day/q/NC/Charlotte.json");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }//Cant figure out how to add if/else to try catch for check
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        if (null != mListener)
        {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            Weather w = (Weather)getListAdapter().getItem(position);
            mListener.onFragmentInteraction(w);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Weather weatherObject);
    }

}
