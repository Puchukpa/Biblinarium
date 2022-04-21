package com.project.biblinarium.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;

public class BooksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        getChildFragmentManager().beginTransaction().add(R.id.layout_books_mainPanel, new BooksMyBooksFragment()).commit();
        return inflater.inflate(R.layout.fragment_books, container, false);
    }
}