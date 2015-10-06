package com.example.ravenmargret.java2project1;

/**
 * Created by ravenmargret on 10/6/15.
 */
public class Weather
{
    String mDay;
    String mForcast;
    String mForcastMetric;

    public Weather(String mDay, String mForcast, String mForcastMetric)
    {
        this.mDay = mDay;
        this.mForcast = mForcast;
        this.mForcastMetric = mForcastMetric;
    }

    public String getmDay() {return mDay;}
    public String getmForcast() {return mForcast;}
    public String getmForcastMetric() {return mForcastMetric;}


    public void setmDay(String mDay) { this.mDay = mDay; }
    public void setmForcast(String mForcast) {this.mForcast = mForcast;}
    public void setmForcastMetric(String mForcastMetric) {this.mForcastMetric = mForcastMetric;}

    @Override
    public String toString()
    {
        return mDay + mForcast + mForcastMetric;

    }
}
