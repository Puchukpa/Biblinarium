package com.project.biblinarium.mvvm.viewModels;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.repositories.BooksRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BooksFindBooksViewModel extends ViewModel {

    private BooksRepository booksRepository = new BooksRepository();

    public Bundle[] getBooksBundles() {
        HashMap<String, Book> books = booksRepository.getAllBooks();

        Bundle[] bundles = new Bundle[books.size()];

        Book[] books1 = books.values().toArray(new Book[0]);

        for (int i = 0; i < bundles.length; i++) {
            bundles[i] = new Bundle();
            bundles[i].putString("bookName", books1[i].getName());
            bundles[i].putString("bookAuthor", books1[i].getAuthor());
            bundles[i].putString("bookDescription", books1[i].getDescription());
            bundles[i].putString("bookSize", String.valueOf(books1[i].getPages()));
            bundles[i].putBoolean("isAdded", false);
        }

        return bundles;
    }
}
