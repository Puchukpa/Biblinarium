package com.project.biblinarium.mvvm.models;

import androidx.annotation.NonNull;

import com.project.biblinarium.mvvm.repositories.ClubsRepository;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String nickname;
    private String password;
    private ArrayList<Book> usersBooks;
    private ArrayList<Club> usersClubs;

    public User(int id, @NonNull String login, @NonNull String password, String nickname) {
        this.id = id;
        this.login = login;
        this.password = password;
        if (nickname == null) {
            this.nickname = login + '/' + id;
        } else {
            this.nickname = nickname;
        }
        usersBooks = new ArrayList<>();
        usersClubs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public ArrayList<Book> getUsersBooks() {
        return usersBooks;
    }

    public ArrayList<Club> getUsersClubs() {
        return usersClubs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsersBooks(ArrayList<Book> usersBooks) {
        this.usersBooks = usersBooks;
    }

    public void setUsersClubs(ArrayList<Club> usersClubs) {
        this.usersClubs = usersClubs;
    }
}
