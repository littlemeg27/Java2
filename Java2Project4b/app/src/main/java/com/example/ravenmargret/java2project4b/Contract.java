package com.example.ravenmargret.java2project4b;

/**
 * Created by Brenna Pavlinchak on 11/18/15.
 */
public class Contract
{
    public final class DataContract {
        // The URI that points to our provider on the device.
        public static final String CONTENT_URI =
                "content://com.example.provider/";
        // The name of our data source inside the provider.
        public static final String DATA_SOURCE = "data_table";
        // For easy access, we'll provide a single constant for the combined URI.
        public static final String DATA_SOURCE_URI =
                CONTENT_URI + DATA_SOURCE;
        // The column names for accessing data in our provider.
        public static final String ID = "_id";
        public static final String FIRST_NAME = "_first_name";
        public static final String LAST_NAME = "_last_name";
        public static final String AGE = "_age";
    }
}
