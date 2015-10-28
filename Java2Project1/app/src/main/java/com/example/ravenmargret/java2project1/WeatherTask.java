/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

import android.app.Dialog;
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
    ArrayList<Weather> weatherForecast = new ArrayList<Weather>();
    Context mContext;
    //ArrayList<Weather> mObjects;
    ProgressDialog dialog;
    WeatherDataReceiver mReceiver;

    public WeatherTask(Context mContext)
    {
        this.mContext = mContext;
        dialog = new ProgressDialog(mContext);
    }

    public interface WeatherDataReceiver
    {
        void receiveData(Context d, ArrayList<Weather> weatherForecast);
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
                //Log.e("Testing",result);

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
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
            //Log.e("JSON DATA", s);

            dialog.cancel();

            try
            {
                JSONObject weather = new JSONObject(s);
                JSONObject forecastObject = weather.getJSONObject("forecast");
                JSONObject weatherObject = forecastObject.getJSONObject("txt_forecast");

                JSONArray weatherArray = weatherObject.getJSONArray("forecastday");

                //mReceiver.receiveData(Weather);
                for (int i = 0; i < weatherArray.length(); i++)
                {
                    JSONObject insideObject = weatherArray.getJSONObject(i);
                    //Log.e("After weather", insideObject);
                    String day;
                    String forcast;
                    String forcastMetric;

                    day = insideObject.getString("title");
                    forcast = insideObject.getString("fcttext");
                    forcastMetric = insideObject.getString("fcttext_metric");
                    Log.e("Weather data", forcast);

                    weatherForecast.add(new Weather(day, forcast, forcastMetric));
                }

            }
            catch (JSONException e)
            {
                //Toast toast = Toast.makeText(MainActivity.this, "Something Happened", Toast.LENGTH_SHORT);
                //toast.show();
            }
        }
}
