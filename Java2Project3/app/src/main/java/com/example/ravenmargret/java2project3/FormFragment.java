/**
 * Created by Brenna Pavlinchak on 11/9/15.
 */

package com.example.ravenmargret.java2project3;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FormFragment extends Fragment implements View.OnClickListener
{
    
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

        //findViewById(R.id.addPersonButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

    }
}
