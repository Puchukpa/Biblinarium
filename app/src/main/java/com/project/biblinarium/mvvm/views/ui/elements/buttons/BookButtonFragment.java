package com.project.biblinarium.mvvm.views.ui.elements.buttons;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.biblinarium.R;
import com.project.biblinarium.mvvm.viewModels.books.BooksBookButtonViewModel;
import com.project.biblinarium.mvvm.views.activities.BookActivity;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksBookPageFragment;
import com.project.biblinarium.mvvm.views.ui.pages.books.BooksFragment;

public class BookButtonFragment extends Fragment{

    TextView bookName;
    TextView bookAuthor;
    TextView bookSize;
    ImageView bookPicture;
    Button bookButton;

    BooksBookButtonViewModel bookButtonViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_element_button_book_button, container, false);

        bookButtonViewModel = new ViewModelProvider(this).get(BooksBookButtonViewModel.class);

        bookName = view.findViewById(R.id.textView_element_buttons_bookName);
        bookAuthor = view.findViewById(R.id.textView_element_buttons_bookAuthor);
        bookSize = view.findViewById(R.id.textView_element_buttons_bookSize);
        bookPicture = view.findViewById(R.id.imageView_element_buttons_bookImage);
        bookButton = view.findViewById(R.id.button_fragment_books_bookButton);

        bookButtonViewModel.setBundle(requireArguments());

        bookName.setText(bookButtonViewModel.getBookName());
        bookAuthor.setText(bookButtonViewModel.getBookAuthor());
        bookSize.setText(bookButtonViewModel.getBookSize());

        bookButton.setOnClickListener(v -> {
            Bundle bundle = bookButtonViewModel.getBundle();
            if (!bookButtonViewModel.isAdded()) {
                BooksFragment parentFragment = (BooksFragment) getParentFragment().getParentFragment();
                parentFragment
                        .getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.layout_books_mainPanel, BooksBookPageFragment.class, bundle)
                        .commit();
            } else {
                Intent intent = new Intent(getContext(), BookActivity.class);
                intent.putExtra(Intent.EXTRA_TITLE, bundle.getString("bookName"));
                startActivity(intent);
            }
        });

        return view;
    }
}