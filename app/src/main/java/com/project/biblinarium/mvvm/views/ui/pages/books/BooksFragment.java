package com.project.biblinarium.mvvm.views.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.books.BooksViewModel;

public class BooksFragment extends Fragment {

    BooksMyBooksFragment myBooksFragment;
    BooksFindBooksFragment findBooksFragment;
    BooksBookPageFragment bookPageFragment;

    BooksViewModel booksVM;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        booksVM = new ViewModelProvider(this).get(BooksViewModel.class);

        myBooksFragment = new BooksMyBooksFragment();
        findBooksFragment = new BooksFindBooksFragment();
        bookPageFragment = new BooksBookPageFragment();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.layout_books_mainPanel, myBooksFragment)
                .commit();

        return view;
    }
}