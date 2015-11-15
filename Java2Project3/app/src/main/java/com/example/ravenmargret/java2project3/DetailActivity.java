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
import android.util.Log;

public class DetailActivity extends Activity
{
    FragmentManager manager;
    public static final String PERSONKEY = "thePersonKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        manager = getFragmentManager();

        DetailFragment detailFragment = new DetailFragment();
        showDetailFragment(detailFragment);

        Intent callingIntent = getIntent();
        callingIntent.getSerializableExtra(PERSONKEY);
        //Log.e("Intent open:", );

    }

    private void showDetailFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container, detailFrag).commit();
    }
}
