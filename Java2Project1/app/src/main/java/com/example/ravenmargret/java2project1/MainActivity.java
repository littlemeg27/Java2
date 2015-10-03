package com.example.ravenmargret.java2project1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity implements ItemFragment.On
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
    }

    private void showMasterFragment(Fragment masterFrag)
    {
        manager.beginTransaction().add(R.id.container, masterFrag).commit();
    }
}
