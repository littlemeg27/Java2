/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

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


    public DetailFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container2, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle args = getArguments();
        if (args != null)
        {
            // Set article based on argument passed in
            updateText(args.getInt(ARG_POSITION));
        }
        else if (mCurrentPosition != -1)
        {
            // Set article based on saved instance state defined during onCreateView
            updateText(mCurrentPosition);
        }   //Not sure what mCurrentPosition is for, its set to -1 but not sure why -1
    }

    public void updateText(String id)
    {
        TextView dayText = (TextView) getActivity().findViewById(R.id.dayTextView);
        dayText.setText(id);

        TextView forcastTextView = (TextView) getActivity().findViewById(R.id.forcastTextView);
        forcastTextView.setText(id);

        TextView MetricForcastTextView = (TextView) getActivity().findViewById(R.id.MetricForcastTextView);
        MetricForcastTextView.setText(id);
    }
}
