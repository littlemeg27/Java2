/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
        args.putInt(DetailFragment.ARG_POSITION, position);
        detailFragment.setArguments(args);
        //According to project ARG_POSITION = final static String ARG_POSITION = "position";
        //Not sure what the ARG_POSITION, position are for.

        showDetailFragment(detailFragment); //Make Detail frag show

        //getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        //Android docs says do this not sure about

//        Toast.makeText(this, "This is the one selected " + id, Toast.LENGTH_SHORT).show();
//        DetailFragment detailFragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.container2);
//
//        if (detailFragment != null)
//        {
//            detailFragment.updateText(id);
//        }
//        else
//        {
//            detailFragment = new DetailFragment();
//            showDetailFragment(detailFragment);
//        }
    }
}
