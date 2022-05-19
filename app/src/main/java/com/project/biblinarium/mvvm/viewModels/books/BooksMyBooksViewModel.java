package com.project.biblinarium.mvvm.viewModels.books;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.biblinarium.mvvm.models.Book;
import com.project.biblinarium.mvvm.repositories.UserRepository;

import java.util.ArrayList;

public class BooksMyBooksViewModel extends ViewModel {

    private final MutableLiveData<EditText> searchingQuery = new MutableLiveData<>();

    public MutableLiveData<EditText> getSearchingQuery() {
        return searchingQuery;
    }

    public Bundle[] getBooksBundles(String query) {
        ArrayList<Book> books = UserRepository.getCurrentUser().getUsersBooks();
        Bundle[] bundles = new Bundle[books.size()];

        for (int i = 0; i < bundles.length; i++) {
            bundles[i] = new Bundle();
            if (books.get(i).getName().contains(query)) {
                bundles[i].putString("bookName", books.get(i).getName());
                bundles[i].putString("bookAuthor", books.get(i).getAuthor());
                bundles[i].putString("bookSize", String.valueOf(books.get(i).getPages()));
                bundles[i].putBoolean("isAdded", true);
            }
        }

        return bundles;
    }
}
