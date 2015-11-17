/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

package com.example.ravenmargret.java2project4a;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment implements View.OnClickListener
{
    public static final String KEY = "PersonKey";
    Button deletePersonButton;

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
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        deletePersonButton = (Button)getView().findViewById(R.id.deletePersonButton);
        deletePersonButton.setOnClickListener(this);
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

    @Override
    public void onClick(View v)
    {
        Toast.makeText(getActivity(), "Contact Deleted", Toast.LENGTH_LONG).show();

//        Form form = new Form(firstName, lastName, age);
//        FormUtil.delete(form, getActivity());
        //Tried to add delete button, ran out of time to finish dealing with the call for it resets just isnt deleting

        getActivity().finish();
    }
}
