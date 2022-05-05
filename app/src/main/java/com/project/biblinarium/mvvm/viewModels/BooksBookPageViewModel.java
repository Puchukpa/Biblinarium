package com.project.biblinarium.mvvm.viewModels;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.models.User;
import com.project.biblinarium.mvvm.repositories.BooksRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

public class BooksBookPageViewModel extends ViewModel {

    private UserRepository userRepository = new UserRepository();
    private BooksRepository booksRepository = new BooksRepository();

    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String bookSize;
    private Bundle bundle;

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
        this.bookName = bundle.getString("bookName");
        this.bookAuthor = bundle.getString("bookAuthor");
        this.bookDescription = bundle.getString("bookDescription");
        this.bookSize = bundle.getString("bookSize");
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void addBook() {
        Book book = booksRepository.getBook(bookName);
        // TODO: исправить баг
        if (!UserRepository.getCurrentUser().getUsersBooks().contains(book)) {
            UserRepository.getCurrentUser().getUsersBooks().add(book);
        }
    }
}
