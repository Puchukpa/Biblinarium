package com.project.biblinarium.mvvm.views.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.books.BooksFindBooksViewModel;
import com.project.biblinarium.mvvm.views.ui.elements.SearchingLineElement;
import com.project.biblinarium.mvvm.views.ui.elements.buttons.BookButtonFragment;

import java.util.ArrayList;

public class BooksFindBooksFragment extends Fragment {

    Button myBooksButton;

    BooksFindBooksViewModel findBooksViewModel;
    SearchingLineElement findBooksSearchingLineElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books_find_books, container, false);

        myBooksButton = view.findViewById(R.id.button_fragment_books_findBooks_myBooks);

        findBooksViewModel = new ViewModelProvider(this).get(BooksFindBooksViewModel.class);
        findBooksSearchingLineElement = new SearchingLineElement();

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_books_findBooks_searchingPanel, findBooksSearchingLineElement)
                .commit();

        ArrayList<Bundle> booksBundles = findBooksViewModel.getBooksBundles();
        for (Bundle bundle : booksBundles) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.layout_fragment_books_findBooks_findBooksButtons,
                            BookButtonFragment.class,
                            bundle)
                    .commit();
        }

        myBooksButton.setOnClickListener(v -> {
            BooksFragment parentFragment = (BooksFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_books_mainPanel, parentFragment.myBooksFragment)
                    .commit();
        });

        return view;
    }
}