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

            try
            {
                ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE); //Check network class
                WeatherTask myTask = new WeatherTask(mContext);
                myTask.execute("http://api.wunderground.com/api/7cba3eee76e99b48/forecast10day/q/SC/Charleston.json");
            }
            catch (Exception e)
            {
                Log.e(TAG, "Invalid query for review: ");
            }

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
    public void onFragmentInteraction(String id)
    {
        Toast.makeText(this, "This is the one selected " + id, Toast.LENGTH_SHORT).show();
        //DetailFragment detailFragment = new DetailFragment();

        DetailFragment detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.layout.detail_fragment);

        if (detailFragment != null)
        {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            //showDetailFragment(detailFragment);
            detailFragment.onCreateView(position);
        }
    }
}
