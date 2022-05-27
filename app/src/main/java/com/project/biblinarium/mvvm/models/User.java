package com.project.biblinarium.mvvm.models;

import androidx.annotation.NonNull;

import com.project.biblinarium.mvvm.repositories.ClubsRepository;

import java.util.ArrayList;
import java.util.Objects;

/**
 * User class
 * @author Puchukpa
 * @version 1.0
 */
public class User {

    /** User's id */
    private int id;

    /** User's login */
    private String login;

    /** User's nickname */
    private String nickname;

    /** User's password */
    private String password;

    /** List of user's books */
    private ArrayList<Book> usersBooks;

    /** List of user's clubs */
    private ArrayList<Club> usersClubs;

    /**
     * Class constructor. Sets initial values
     * @param id user's ID
     * @param login user's login
     * @param password user's password
     * @param nickname user's nickname
     */
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

    /**
     * Returns field {@link User#id}
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Returns field {@link User#login}
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Returns field {@link User#password}
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns field {@link User#nickname}
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Returns list of user's books
     * @return
     */
    public ArrayList<Book> getUsersBooks() {
        return usersBooks;
    }

    /**
     * Returns list if user's clubs
     * @return
     */
    public ArrayList<Club> getUsersClubs() {
        return usersClubs;
    }

    /**
     * Sets field {@link User#id}
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets field {@link User#login}
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Sets field {@link User#password}
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets field {@link User#nickname}
     * @param nickname
     */
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
