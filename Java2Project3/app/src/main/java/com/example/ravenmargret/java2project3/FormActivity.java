/**
 * Created by Brenna Pavlinchak on 11/9/15.
 */

package com.example.ravenmargret.java2project3;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class FormActivity extends ActionBarActivity
{
    FragmentManager manager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mContext = this;
        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showFormFragment(formFragment);
    }

    private void showFormFragment(Fragment formFrag)
    {
        manager.beginTransaction().add(R.id.container.formFrag).commit();
    }
}
