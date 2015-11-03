/**
 * Created by Brenna Pavlinchak on 10/10/15.
 */

package com.example.ravenmargret.java2project1;

import java.io.Serializable;

public class Weather implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
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


    public void setmDay(String mDay) {this.mDay = mDay;}
    public void setmForcast(String mForcast) {this.mForcast = mForcast;}
    public void setmForcastMetric(String mForcastMetric) {this.mForcastMetric = mForcastMetric;}

    @Override
    public String toString()
    {
        return mDay;
    }
}
