package com.project.biblinarium.mvvm.views.ui.pages.books;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.BooksBookPageViewModel;

public class BooksBookPageFragment extends Fragment {

    TextView bookName;
    TextView bookAuthor;
    TextView bookDescription;

    FloatingActionButton back;
    FloatingActionButton download;
    FloatingActionButton findAndExchange;
    FloatingActionButton findAndReserve;
    
    BooksBookPageViewModel bookPageViewModel;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books_book_page, container, false);

        bookPageViewModel = new ViewModelProvider(this).get(BooksBookPageViewModel.class);
        
        bookName = view.findViewById(R.id.textView_fragment_books_bookName);
        bookAuthor = view.findViewById(R.id.textView_fragment_books_bookAuthor);
        bookDescription = view.findViewById(R.id.textView_fragment_books_bookDescription);
        back = view.findViewById(R.id.floatingActionButton_fragment_books_bookPage_back);
        download = view.findViewById(R.id.floatingActionButton_fragment_books_bookPage_download);
        findAndExchange = view.findViewById(R.id.floatingActionButton_fragment_books_bookPage_findAnnouncement);
        findAndReserve = view.findViewById(R.id.floatingActionButton_fragment_books_bookPage_reserve);
        
        bookPageViewModel.setBundle(requireArguments());

        bookName.setText(bookPageViewModel.getBookName());
        bookAuthor.setText(bookPageViewModel.getBookAuthor());
        bookDescription.setText(bookPageViewModel.getBookDescription());

        back.setOnClickListener(v -> {
            BooksFragment parentFragment = (BooksFragment) getParentFragment();
            parentFragment.getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.layout_books_mainPanel, parentFragment.findBooksFragment)
                    .show(parentFragment.searchingLine)
                    .commit();
        });

        download.setOnClickListener(v -> {
            bookPageViewModel.addBook();
        });

        return view;
    }
}