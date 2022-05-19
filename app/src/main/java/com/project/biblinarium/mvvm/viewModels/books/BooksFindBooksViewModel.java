package com.project.biblinarium.mvvm.viewModels.books;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.repositories.BooksRepository;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BooksFindBooksViewModel extends ViewModel {

    private BooksRepository booksRepository = new BooksRepository();

    public ArrayList<Bundle> getBooksBundles() {
        ArrayList<Book> books = new ArrayList<>(booksRepository.getAllBooks().values());
        ArrayList<Book> newBooks = new ArrayList<>();

        for (Book bookI : books) {
            newBooks.add(bookI);
            for (Book bookJ : UserRepository.getCurrentUser().getUsersBooks()) {
                if (bookI.getName().equals(bookJ.getName())) {
                    newBooks.remove(bookI);
                }
            }
        }

        ArrayList<Bundle> bundles = new ArrayList<>();
        for (Book book : newBooks) {
            Bundle bundle = new Bundle();
            bundle.putString("bookName", book.getName());
            bundle.putString("bookAuthor", book.getAuthor());
            bundle.putString("bookDescription", book.getDescription());
            bundle.putString("bookSize", String.valueOf(book.getPages()));
            bundle.putBoolean("isAdded", false);
            bundles.add(bundle);
        }

        return bundles;
    }
}
