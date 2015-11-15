package com.example.ravenmargret.java2project3;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment
{
    public static final String KEY = "PersonKey";

    public DetailFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle args = getArguments();
        if (args != null)
        {
            // Set article based on argument passed in
            updateText((Form)args.getSerializable(KEY));
        }
    }

    public void updateText(Form object)
    {
        TextView dayText = (TextView) getActivity().findViewById(R.id.firstTextView);
        dayText.setText(object.getmFirstName());

        TextView forecastTextView = (TextView) getActivity().findViewById(R.id.lastTextView);
        forecastTextView.setText(object.getmLastName());

        TextView metricForecastTextView = (TextView) getActivity().findViewById(R.id.ageTextView);
        metricForecastTextView.setText(object.getmAge());
    }
}
