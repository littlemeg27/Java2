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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements WeatherTask.WeatherDataReceiver
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
        //setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, weatherForecast));
        //Change above for

        weatherSpinner = (Spinner) findViewById//findViewById(R.id.weatherSpinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(MasterFragment.this, R.array.spinnerArray, android.R.layout.simple_dropdown_item_1line);
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
    public void onListItemClick(ListView l, View v, int position, long id
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

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Weather weatherObject);
    }
}

/*
public class MasterFragment extends ListFragment implements WeatherTask.WeatherDataReceiver
{
    ArrayList<Weather> mObjects;
    private OnFragmentInteractionListener mListener;
    Spinner citySpinner;
    ArrayAdapter<String> spinnerAdapter;
    public static String fileName = "api.ser";

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


public interface OnFragmentInteractionListener //This method transfers data to the other fragment
{
    // TODO: Update argument type and name
    public void onFragmentInteraction(Weather weatherObject);
}
}
 */
