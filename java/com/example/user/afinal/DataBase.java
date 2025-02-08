package com.example.user.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="all_users";
    public static final String NICKNAME="Nickname";
    public static final String PASS="Password";
    public static final String FAVCOLOR="Favcolor";
    String SQL_Create="", SQL_DELETE="";

    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        SQL_Create="Create TABLE "+TABLE_NAME+" (";
        SQL_Create+=NICKNAME+" TEXT, ";
        SQL_Create+=PASS+" TEXT, ";
        SQL_Create+=FAVCOLOR+" TEXT); ";
        sqLiteDatabase.execSQL(SQL_Create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        SQL_DELETE="DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE);
        onCreate(sqLiteDatabase);

    }

}
