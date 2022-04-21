package com.project.biblinarium.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;
import com.project.biblinarium.ui.elements.buttons.BookButtonFragment;

import java.util.ArrayList;

public class BooksMyBooksFragment extends Fragment {

    // private ArrayList<BookButtonFragment> books = new ArrayList<>(3);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.layout_fragment_books_myBooks_myBooksButtons, new BookButtonFragment()).commit();
        return inflater.inflate(R.layout.fragment_books_my_books, container, false);
    }
}