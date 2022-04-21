package com.project.biblinarium.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.biblinarium.mvvm.models.User;

import java.util.List;
import java.util.Set;

public class UserDBHandler {

    private final SQLiteDatabase userDB;
    private final String[] userDBProjection = {
            UserDBContract.User._ID,
            UserDBContract.User.USER_LOGIN,
            UserDBContract.User.USER_PASSWORD,
            UserDBContract.User.USER_NICKNAME
    };

    public UserDBHandler (Context context) {
        userDB = new UserDBHelper(context).getWritableDatabase();
    }

    public long add (String login, String password, String nickname) {
        ContentValues cv = new ContentValues();
        cv.put(UserDBContract.User.USER_LOGIN, login);
        cv.put(UserDBContract.User.USER_PASSWORD, password);
        cv.put(UserDBContract.User.USER_NICKNAME, nickname);

        return userDB.insert(
                UserDBContract.User.TABLE_NAME,
                null,
                cv
        );
    }

    public User getUser (String login) {
        User resultUser;

        try (Cursor c = userDB.query(
                UserDBContract.User.TABLE_NAME,
                userDBProjection,
                null,null,null, null, null)) {

            int idColumnIndex = c.getColumnIndex(UserDBContract.User._ID);
            int loginColumnIndex = c.getColumnIndex(UserDBContract.User.USER_LOGIN);
            int passwordColumnIndex = c.getColumnIndex(UserDBContract.User.USER_PASSWORD);
            int nicknameColumnIndex = c.getColumnIndex(UserDBContract.User.USER_NICKNAME);

            while (c.moveToNext()) {
                if (c.getString(loginColumnIndex).equals(login)) {
                    int userId = c.getInt(idColumnIndex);
                    String userLogin = c.getString(loginColumnIndex);
                    String userPassword = c.getString(passwordColumnIndex);
                    String userNickname = c.getString(nicknameColumnIndex);

                    return new User(userId, userLogin, userPassword, userNickname);
                }
            }

            return null;
        }

    }
}
