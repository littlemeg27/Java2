package com.example.ravenmargret.java2project4a;

/**
 * Created by Brenna Pavlinchak on 11/17/15.
 */

public final class Contract
{

        // The URI that points to our provider on the device.
        public static final String CONTENT_URI = "content://com.example.ravenmargret.java2project4a.CRUDProvider/";

        // The name of our data source inside the provider.
        public static final String DATA_SOURCE = "Crud";

        // For easy access, we'll provide a single constant for the combined URI.
        public static final String DATA_SOURCE_URI =
                CONTENT_URI + DATA_SOURCE;

        // The column names for accessing data in our provider.
        public static final String ID = "_id";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String AGE = "age";

}
