/**
 * Created by Brenna Pavlinchak on 11/4/15.
 */


package com.example.ravenmargret.java2project2;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements WeatherTask.WeatherDataReceiver, AdapterView.OnItemSelectedListener
{

    ArrayList<Weather> mObjects;
    private OnFragmentInteractionListener mListener;
    ArrayAdapter<String> spinnerAdapter;
    public static String fileName = "api.ser";
    Spinner citySpinner;
    Spinner weatherSpinner;

    @Override
    public void receiveData(ArrayList<Weather> weatherForecast)
    {
        //Get in weather data
        weatherSpinner = (Spinner)getView().findViewById(R.id.weatherSpinner); //Get view for spinner
        weatherSpinner.setOnItemSelectedListener(this); //set the listener to the weather spinner
        ArrayAdapter spinnerAdapter = (new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, weatherForecast));
        weatherSpinner.setAdapter(spinnerAdapter);
    }

    public MasterFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
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

        try
        {
            WeatherTask myTask = new WeatherTask(getActivity(), this);
            myTask.execute("http://api.wunderground.com/api/7cba3eee76e99b48/forecast10day/q/NC/Charlotte.json");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> l, View v, int position, long id)
    {
        if (null != mListener)
        {
            Weather w = (Weather)weatherSpinner.getAdapter().getItem(position);
            mListener.onFragmentInteraction(w);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        //Useless but needed
    }

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Weather weatherObject);
    }
}
