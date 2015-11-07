/**
 * Created by Brenna Pavlinchak on 11/4/15.
 */

package com.example.ravenmargret.java2project2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements MasterFragment.OnFragmentInteractionListener
{
    FragmentManager manager;
    final String TAG = "API TEST";
    //API key 7cba3eee76e99b48
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        manager = getFragmentManager();

        MasterFragment masterFragment = new MasterFragment();
        showMasterFragment(masterFragment);
    }

    private void showMasterFragment(Fragment masterFrag)
    {
        manager.beginTransaction().add(R.id.container, masterFrag).commit();
    }

    private void showDetailFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container2, detailFrag).commit();
    }

    @Override
    public void onFragmentInteraction(Weather weatherObject)
    {
        //Create new details fragment, pass weather object to details frag add details frag to layout
        //Dont do what is shown its wrong

        DetailFragment detailFragment = new DetailFragment(); //Creating details fragment

        Bundle args = new Bundle();
        args.putSerializable(DetailFragment.WEATHERKEY, weatherObject);
        detailFragment.setArguments(args);

        showDetailFragment(detailFragment); //Make Detail frag show
    }
}
