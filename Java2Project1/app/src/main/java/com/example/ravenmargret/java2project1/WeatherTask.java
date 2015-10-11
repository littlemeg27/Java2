/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */
package com.example.ravenmargret.java2project1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
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


public class WeatherTask extends AsyncTask<String, Void, String>
{
    final String TAG = "API DEMO AsyncTask";
    Context mContext;
    mContext = this;
    ProgressDialog dialog = new ProgressDialog(MasterFragment.this);
    WeatherDataReceiver mReceiver;

    public interface WeatherDataReceiver
    {
        void receiveData(ArrayList<> _weather);
    }

    public WeatherTask(WeatherDataReceiver _receiver)
    {
        mReceiver = _receiver;
    }

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
                Toast toast = Toast.makeText(MasterFragment.this, "Could not find the anything try again", Toast.LENGTH_SHORT);
                toast.show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MasterFragment.this, "Could not find anything try again", Toast.LENGTH_SHORT);
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
                //JSONObject reviewObject = new JSONObject(s);
                //JSONArray reviewArray = reviewObject.getJSONArray("MovieReviews");
                mReceiver.receiveData(weather);

                for (int i = 0; i < reviewArray.length(); i++)
                {
                    /*JSONObject insideObject = reviewArray.getJSONObject(i);
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

                    movieReviews.add(new Weather(movieName, actorName, releaseDate, director, review));*/
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
