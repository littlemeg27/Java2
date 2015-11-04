/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class WeatherTask extends AsyncTask<String, Void, ArrayList<Weather>>
{
    final String TAG = "API DEMO AsyncTask";
    ArrayList<Weather> weatherForecast = new ArrayList<Weather>();
    Context mContext;
    ProgressDialog dialog;
    WeatherDataReceiver mReceiver;

    public WeatherTask(Context mContext, WeatherDataReceiver _receiver)
    {
        this.mContext = mContext;
        dialog = new ProgressDialog(mContext);
        mReceiver = _receiver;
    }

    public interface WeatherDataReceiver
    {
        void receiveData(ArrayList<Weather> weatherForecast);
    }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading...");
            dialog.setTitle("Network Call");
            dialog.show();

            try
            {
                ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE); //Check network class
                NetworkInfo network = manager.getActiveNetworkInfo();
                if(network == null)
                {
                    //read(Context context);//Save data
                }
                else
                {
                    //WeatherTask myTask = new WeatherTask(getActivity(), this);
                    WeatherTask myTask = new WeatherTask(mContext,this.mReceiver);

                    //use spinner here
                /*citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        city.setText(spinnerArray.get(position).toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                });*/
                    //Move connect to Task
                    myTask.execute("http://api.wunderground.com/api/7cba3eee76e99b48/forecast10day/q/NC/Charlotte.json");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        @Override
        protected ArrayList<Weather> doInBackground(String... params)
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
                //Saving loading goes here

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                JSONObject weather = new JSONObject(result);
                JSONObject forecastObject = weather.getJSONObject("forecast");
                JSONObject weatherObject = forecastObject.getJSONObject("txt_forecast");

                JSONArray weatherArray = weatherObject.getJSONArray("forecastday");

                for (int i = 0; i < weatherArray.length(); i++)
                {
                    JSONObject insideObject = weatherArray.getJSONObject(i);
                    String day;
                    String forecast;
                    String forecastMetric;

                    day = insideObject.getString("title");
                    forecast = insideObject.getString("fcttext");
                    forecastMetric = insideObject.getString("fcttext_metric");
                    Log.e("Weather data", forecast);

                    weatherForecast.add(new Weather(day, forecast, forecastMetric));
                }

            }
            catch (JSONException e)
            {
                //Toast toast = Toast.makeText(MainActivity.this, "Something Happened", Toast.LENGTH_SHORT);
                //toast.show();
            }
            return weatherForecast;
        }



        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(ArrayList<Weather> weatherAPI)
        {
            super.onPostExecute(weatherAPI);

            dialog.cancel();
            mReceiver.receiveData(weatherForecast);
        }


}
