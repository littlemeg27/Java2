package com.example.ravenmargret.java2project3;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ravenmargret.java2project3.dummy.DummyContent;

import java.util.ArrayList;


public class PersonListFragment extends ListFragment
{
    public PersonListFragment()
    {

    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Form f = (Form)getListAdapter().getItem(position);
    }

    public void loadData()
    {
        ArrayList<Form> formObject = FormUtil.load(getActivity());
        ArrayAdapter<Form> formArrayAdapter = new ArrayAdapter<Form>(getActivity(), android.R.layout.simple_list_item_1, formObject);
        setListAdapter(formArrayAdapter);
    }
}
