package com.example.user.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Saves extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="save.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="all_saves";
    public static final String Mapname="Mapname";
    public static final String Xcoor="Xcoordinate";
    public static final String Ycoor="Ycoordinate";
    String SQL_Create="", SQL_DELETE="";

    public Saves(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        SQL_Create="Create TABLE "+TABLE_NAME+" (";
        SQL_Create+=Mapname+" TEXT, ";
        SQL_Create+=Xcoor+" TEXT, ";
        SQL_Create+=Ycoor+" TEXT, ";
        sqLiteDatabase.execSQL(SQL_Create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQL_DELETE="DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE);
        onCreate(sqLiteDatabase);

    }
}
