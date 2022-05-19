package com.project.biblinarium.mvvm.repositories;

import com.project.biblinarium.mvvm.models.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRepository {

    private final static ArrayList<User> users = new ArrayList<>();

    private static User currentUser = null;
    private static int lastUsedId = 5;

    public static void init () {
        BooksRepository booksRepository = new BooksRepository();
        ClubsRepository clubsRepository = new ClubsRepository();

        String[][] booksIndexes = {
                {"Book1", "Book2", "Book3"},
                {"Book2", "Book3", "Book4"},
                {"Book5"},
                {"Book2", "Book5"},
                {"Bool4", "Book5"}
        };
        String[][] clubsIndexes = {
                {"Club1", "Club2", "Club3", "Club4"},
                {"Club1", "Club3"},
                {"Club2", "Club4", "Club5"},
                {},
                {"Club5"}
        };

        users.add(new User(1, "login1", "password1", "Albert"));
        users.get(0).setUsersBooks(booksRepository.getSomeBooks(booksIndexes[0]));
        users.get(0).setUsersClubs(clubsRepository.getSomeClubs(clubsIndexes[0]));
        users.add(new User(2, "login2", "password2", "Boris"));
        users.get(1).setUsersBooks(booksRepository.getSomeBooks(booksIndexes[1]));
        users.get(1).setUsersClubs(clubsRepository.getSomeClubs(clubsIndexes[1]));
        users.add(new User(3, "login3", "password3", "Carl"));
        users.get(2).setUsersBooks(booksRepository.getSomeBooks(booksIndexes[2]));
        users.get(2).setUsersClubs(clubsRepository.getSomeClubs(clubsIndexes[2]));
        users.add(new User(4, "login4", "password4", "Dexter"));
        users.get(3).setUsersBooks(booksRepository.getSomeBooks(booksIndexes[3]));
        users.get(3).setUsersClubs(clubsRepository.getSomeClubs(clubsIndexes[3]));
        users.add(new User(5, "login5", "password5", "Eugen"));
        users.get(4).setUsersBooks(booksRepository.getSomeBooks(booksIndexes[4]));
        users.get(4).setUsersClubs(clubsRepository.getSomeClubs(clubsIndexes[4]));
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean setCurrentUser(String login, String password) {
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        currentUser = null;
        return false;
    }

    public static boolean addNewUser(String login, String password, String nickname) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }

        users.add(new User(++lastUsedId, login, password, nickname));
        return true;
    }
}
