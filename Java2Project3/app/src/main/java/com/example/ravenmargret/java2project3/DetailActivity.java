/**
 * Created by Brenna Pavlinchak on 11/9/15.
 */

package com.example.ravenmargret.java2project3;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class DetailActivity extends ActionBarActivity
{
    Context mContext;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

}
