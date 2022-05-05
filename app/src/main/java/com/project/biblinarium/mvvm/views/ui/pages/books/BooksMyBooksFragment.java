package com.project.biblinarium.mvvm.views.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.BooksMyBooksViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.BookButtonFragment;

public class BooksMyBooksFragment extends Fragment {

    Button findBooksButton;

    BooksMyBooksViewModel myBooksViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books_my_books, container, false);

        findBooksButton = view.findViewById(R.id.button_fragment_books_myBooks_findBooks);

        myBooksViewModel = new ViewModelProvider(this).get(BooksMyBooksViewModel.class);

        Bundle[] booksBundles = myBooksViewModel.getBooksBundles();
        for (Bundle bundle : booksBundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_books_myBooks_myBooksButtons,
                            BookButtonFragment.class,
                            bundle)
                    .commit();
        }

        findBooksButton.setOnClickListener(v -> {
            BooksFragment parentFragment = (BooksFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_books_mainPanel, parentFragment.findBooksFragment)
                    .commit();
        });

        return view;
    }
}