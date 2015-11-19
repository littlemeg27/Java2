/**
 * Created by Brenna Pavlinchak on 11/19/15.
 */

package com.example.ravenmargret.java2project4a;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;


public class CRUDProvider extends ContentProvider
{
    private static final String AUTHORITY = "com.example.ravenmargret.java2project4a.CRUDProvider";
    private static final String BASE_DATA =
    @Override
    public boolean onCreate()
    {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri)
    {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        return 0;
    }
}
