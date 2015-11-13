/**
 * Created by Brenna Pavlinchak on 11/9/15.
 */

package com.example.ravenmargret.java2project3;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormFragment extends Fragment implements View.OnClickListener
{
    private OnFragmentInteractionListener mListener;
    Button saveButton;
    EditText firstNameText;
    EditText lastNameText;
    EditText ageText;

    public interface contactDetails
    {
        public void receiveData(String _firstName, String _lastName, String _age);
    }

    public FormFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

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
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        firstNameText = (EditText)getView().findViewById(R.id.firstNameText);
        lastNameText = (EditText)getView().findViewById(R.id.lastNameText);
        ageText = (EditText)getView().findViewById(R.id.ageText);

        saveButton = (Button)getView().findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String firstName = mFirstName.getText().toString();
        String lastName = mLastName.getText().toString();
        String age = mAge.getText().toString();

        String result = "";
        Log.e("It did something",result);

    }

    public interface OnFragmentInteractionListener //This method transfers data to the other fragment
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Form weatherObject);
    }
}
