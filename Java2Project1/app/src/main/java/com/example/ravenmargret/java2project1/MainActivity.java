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
                ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//Check network class
                MyTask myTask = new MyTask();
                myTask.execute("http://api.wunderground.com/api/7cba3eee76e99b48/forecast10day/q/" + SC + "/" + Charleston + ".json");
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
        DetailFragment detailFragment = new DetailFragment();
        showDetailFragment(detailFragment);
    }

    public void onClick(View v)
    {
        //Search button
    }

    private class MyTask extends AsyncTask<String, Void, String>
    {
        final String TAG = "API DEMO AsyncTask";

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading...");
            dialog.setTitle("Network Call");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params)
        {
            String result = "";

            try
            {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                result = IOUtils.toString(is);
                is.close();

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find the anything try again", Toast.LENGTH_SHORT);
                toast.show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find anything try again", Toast.LENGTH_SHORT);
                toast.show();
            }

            return result;
        }



        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            Log.e("JSON DATA", s);


            try
            {
                JSONObject reviewObject = new JSONObject(s);
                JSONArray reviewArray = reviewObject.getJSONArray("MovieReviews");

                for (int i = 0; i < reviewArray.length(); i++)
                {
                    JSONObject insideObject = reviewArray.getJSONObject(i);
                    String movieName;
                    String actorName;
                    String releaseDate;
                    String director;
                    String review;

                    movieName = insideObject.getString("MovieName");
                    actorName = insideObject.getString("ActorName");
                    releaseDate = insideObject.getString("ReleaseDate");
                    director = insideObject.getString("Director");
                    review = insideObject.getString("Review");

                    movieReviews.add(new Weather(movieName, actorName, releaseDate, director, review));
                }

            }
            catch (JSONException e)
            {
                //Toast toast = Toast.makeText(MainActivity.this, "Something Happened", Toast.LENGTH_SHORT);
                //toast.show();
            }

            CustomAdapter adaptor = new CustomAdapter(mContext, movieReviews);
            reviewList.setAdapter(adaptor);
            dialog.cancel();

        }

    }
}
