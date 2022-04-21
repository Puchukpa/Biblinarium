package com.project.biblinarium.mvvm.models;

import java.util.Objects;

public class User {

    

    private int id;
    private String login;
    private String nickname;
    private String password;

    public User(int id, String login, String nickname, String password) {
        this.id = id;
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.nickname = login + '/' + id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
