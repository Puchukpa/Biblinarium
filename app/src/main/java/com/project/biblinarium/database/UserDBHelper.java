package com.project.biblinarium.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_USERS =
            "CREATE TABLE " + UserDBContract.User.TABLE_NAME + " (" +
            UserDBContract.User._ID + " INTEGER PRIMARY KEY, " +
            UserDBContract.User.USER_LOGIN + " TEXT NOT NULL, " +
            UserDBContract.User.USER_PASSWORD + " TEXT NOT NULL, " +
            UserDBContract.User.USER_NICKNAME + " TEXT);";
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UserDBContract.User.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";

    public UserDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_USERS);
        onCreate(sqLiteDatabase);
    }
}
