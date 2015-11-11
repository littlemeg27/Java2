/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.java2project3;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

public class ListActivity extends ActionBarActivity
{
    FragmentManager manager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mContext = this;
        manager = getFragmentManager();

        DetailFragment listFragment = new DetailFragment();
        showListFragment(listFragment);
    }

    private void showListFragment(Fragment listFrag)
    {
        manager.beginTransaction().add(R.id.container.listFrag).commit();
    }

}
