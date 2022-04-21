package com.project.biblinarium.database;

import android.provider.BaseColumns;

public final class UserDBContract {

    public UserDBContract() {};

    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String USER_LOGIN = "login";
        public static final String USER_PASSWORD = "password";
        public static final String USER_NICKNAME = "nickname";
    }
}
