package com.project.biblinarium.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Arrays;

public class UsersDatabaseHelper extends SQLiteOpenHelper {

    public static final String USERS_TABLE_NAME = "users_table";
    public static final String USERS_TABLE_ID = "id";
    public static final String USERS_TABLE_LOGIN = "login";
    public static final String USERS_TABLE_PASSWORD = "password";
    public static final String USERS_TABLE_NICKNAME = "nickname";

    public UsersDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
