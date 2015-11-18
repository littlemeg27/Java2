/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

package com.example.ravenmargret.java2project4a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PersonListActivity extends Activity implements View.OnClickListener, PersonListFragment.OnFragmentInteractionListener
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        manager = getFragmentManager();

        PersonListFragment listFragment = new PersonListFragment();
        showListFragment(listFragment);

        findViewById(R.id.addPersonButton).setOnClickListener(this);
    }

    private void showListFragment(Fragment listFrag) {
        manager.beginTransaction().replace(R.id.container, listFrag).commit();
    }


    @Override
    public void onClick(View v) {
        Intent nextActivity = new Intent(this, FormActivity.class);
        startActivityForResult(nextActivity, 27272727);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Refresh list here
        //Find person list frag call load data to update list
        PersonListFragment fragment = (PersonListFragment) getFragmentManager().findFragmentById(R.id.container); //Re call the entire frag
        fragment.loadData(); //Call the method inside the frag
    }   //I find this a really weird way to do things but if it works it works

    @Override
    public void onFragmentInteraction(Form formObject) {
        Bundle extras = new Bundle();
        extras.putSerializable(DetailActivity.PERSONKEY, formObject);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, 45454545);
    }
}

