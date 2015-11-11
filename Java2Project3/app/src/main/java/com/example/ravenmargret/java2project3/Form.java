/**
 * Created by Brenna Pavlinchak on 11/11/15.
 */

package com.example.ravenmargret.java2project3;

import java.io.Serializable;

public class Form implements Serializable
{
    private static final long serialVersionUID = 8736847634070552888L;
    String mFirstName;
    String mLastName;
    String mAge; //Haha Celey I took your suggestion to make it simple

    public Form(String mFirstName, String mLastName, String mAge)
    {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mAge = mAge;
    }

    public String getmFirstName() {return mFirstName;}
    public String getmLastName() {return mLastName;}
    public String getmAge() {return mAge;}


    public void setmFirstName(String mFirstName) {this.mFirstName = mFirstName;}
    public void setmLastName(String mLastName) {this.mLastName = mLastName;}
    public void setmAge(String mAge) {this.mAge = mAge;}

    @Override
    public String toString()
    {
        return mFirstName;
    }
}
