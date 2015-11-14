/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.java2project3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonListActivity extends Activity implements View.OnClickListener, PersonListFragment.OnFragmentInteractionListener
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        manager = getFragmentManager();

        PersonListFragment listFragment = new PersonListFragment();
        showListFragment(listFragment);

        findViewById(R.id.addPersonButton).setOnClickListener(this);
    }

    private void showListFragment(Fragment listFrag)
    {
        manager.beginTransaction().replace(R.id.container, listFrag).commit();
    }


    @Override
    public void onClick(View v)
    {
        Intent nextActivity = new Intent(this, FormActivity.class);
        startActivityForResult(nextActivity, 27272727);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //Refresh list here
        //Find person list frag call load data to update list
        PersonListFragment fragment = (PersonListFragment) getFragmentManager().findFragmentById(R.id.container); //Re call the entire frag
        fragment.loadData(); //Call the method inside the frag
    }   //I find this a really weird way to do things but if it works it works


        //Create new details fragment, pass weather object to details frag add details frag to layout
        //Dont do what is shown its wrong

//        DetailFragment detailFragment = new DetailFragment(); //Creating details fragment
//
//        Bundle args = new Bundle();
//        args.putSerializable(DetailFragment.WEATHERKEY, weatherObject);
//        detailFragment.setArguments(args);
//
//        showDetailFragment(detailFragment); //Make Detail frag show

    @Override
    public void onFragmentInteraction(Form formObject)
    {
        Bundle extras = new Bundle();
        extras.putAll(extras);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, 45454545);
    }

//
//
//    extras.putString("Name", "John Smith");
//    extras.putInt("Age", 21);
//    Intent intent = new Intent(this, NextActivity.class);
//    intent.putExtras(extras);
//    startActivityForResult(intent, REQUEST_NEXT);
}
