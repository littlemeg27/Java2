/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

package com.example.ravenmargret.java2project4a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class FormActivity extends Activity
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showFormFragment(formFragment);
    }

    private void showFormFragment(Fragment formFrag)
    {
        manager.beginTransaction().replace(R.id.container, formFrag).commit();
    }
}
