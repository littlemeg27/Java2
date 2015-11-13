/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.java2project3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;

public class DetailActivity extends Activity
{
    FragmentManager manager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mContext = this;
        manager = getFragmentManager();

        DetailFragment detailFragment = new DetailFragment();
        showDetailFragment(detailFragment);
    }

    private void showDetailFragment(Fragment detailFrag)
    {
        manager.beginTransaction().replace(R.id.container, detailFrag).commit();
    }
}
