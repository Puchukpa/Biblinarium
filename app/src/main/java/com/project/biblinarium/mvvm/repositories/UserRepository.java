package com.project.biblinarium.mvvm.repositories;

import com.project.biblinarium.mvvm.models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRepository {

    private final ArrayList<User> users = new ArrayList<>();

    private static User currentUser = null;
    private static int lastUsedId = 5;

    public UserRepository () {
        BooksRepository booksRepository = new BooksRepository();
        String[][] indexes = {
                {"Book1", "Book2", "Book3"},
                {"Book2", "Book3", "Book4"},
                {"Book5"},
                {"Book2", "Book5"},
                {"Bool4", "Book5"}
        };
        users.add(new User(1, "login1", "password1", "Albert"));
        users.get(0).setUsersBooks(booksRepository.getSomeBooks(indexes[0]));
        users.add(new User(2, "login2", "password2", "Boris"));
        users.get(1).setUsersBooks(booksRepository.getSomeBooks(indexes[1]));
        users.add(new User(3, "login3", "password3", "Carl"));
        users.get(2).setUsersBooks(booksRepository.getSomeBooks(indexes[2]));
        users.add(new User(4, "login4", "password4", "Dexter"));
        users.get(3).setUsersBooks(booksRepository.getSomeBooks(indexes[3]));
        users.add(new User(5, "login5", "password5", "Eugen"));
        users.get(4).setUsersBooks(booksRepository.getSomeBooks(indexes[4]));
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public boolean setCurrentUser(String login, String password) {
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        currentUser = null;
        return false;
    }

    public static int getLastUsedId() {
        return lastUsedId;
    }

    public static void setLastUsedId(int lastUsedId) {
        UserRepository.lastUsedId = lastUsedId;
    }
}
